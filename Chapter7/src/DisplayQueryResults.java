
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;
import javax.swing.*;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;

public class DisplayQueryResults extends JFrame {

    static final String DATABASE_URL = "jdbc:derby://localhost:1527/countriesdb";
    static final String USERNAME = "nbuser";
    static final String PASSWORD = "nbuser";
    static final String DEFAULT_QUERY = "SELECT * FROM Countries";
    
    private ResultSetTableModel tableModel;
    private JTable resultTable;
    private TableRowSorter<TableModel> sorter;
    
    private JTextArea queryArea;
    private JTextField filterText = new JTextField();
    private JButton submitButton = new JButton("Submit Query");
    private JLabel filterLabel = new JLabel("Filter:");
    private JButton filterButton = new JButton("Apply Filter");
     
    public DisplayQueryResults() {
        try {
            tableModel = new ResultSetTableModel(DATABASE_URL, USERNAME, PASSWORD, DEFAULT_QUERY);
            resultTable = new JTable(tableModel);
            
            queryArea = new JTextArea(DEFAULT_QUERY, 3, 100);
            queryArea.setWrapStyleWord(true);
            queryArea.setLineWrap(true);

            JScrollPane scrollPane = new JScrollPane(queryArea,
                    ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

            // create Box to manage placement of queryArea and submitButton in GUI
            Box boxNorth = Box.createHorizontalBox();
            boxNorth.add(scrollPane);
            boxNorth.add(submitButton);
            submitButton.addActionListener(new SubmitButtonListener());
           
            Box boxSouth = Box.createHorizontalBox();
            boxSouth.add(filterLabel);
            boxSouth.add(filterText);
            boxSouth.add(filterButton);
            filterButton.addActionListener(new FilterButtonListener());
            
            add(boxNorth, BorderLayout.NORTH);
            add(new JScrollPane(resultTable), BorderLayout.CENTER);
            add(boxSouth, BorderLayout.SOUTH);

            sorter = new TableRowSorter<TableModel>(tableModel);
            resultTable.setRowSorter(sorter);
            
           

            // ensure database connection is closed when user quits application
            addWindowListener(new WindowCloseListener());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            tableModel.disconnectFromDatabase();
            System.exit(1);
        }
    }

    private class SubmitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                tableModel.setQuery(queryArea.getText());
                System.out.println("***TRACE: in SubmitButtonListener");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);

                // try to recover from invalid user query by executing default query
                try {
                    tableModel.setQuery(DEFAULT_QUERY);
                    queryArea.setText(DEFAULT_QUERY);
                } catch (SQLException ex2) {
                    JOptionPane.showMessageDialog(null, ex2.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                    tableModel.disconnectFromDatabase();
                    System.exit(1);
                }
            }
        }
    }

    private class FilterButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = filterText.getText();
            if (text.length() == 0) {
                sorter.setRowFilter(null);
            } else {
                try {
                    sorter.setRowFilter(RowFilter.regexFilter(text));
                } catch (PatternSyntaxException pse) {
                    JOptionPane.showMessageDialog(null, "Bad regex pattern", "Bad regex pattern", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private class WindowCloseListener extends WindowAdapter {

        @Override
        public void windowClosed(WindowEvent event) {
            tableModel.disconnectFromDatabase();
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        DisplayQueryResults fra = new DisplayQueryResults();
        fra.setTitle("Displaying Query Results");
        fra.setSize(500, 250);
        fra.setVisible(true);
        fra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
