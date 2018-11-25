import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;
import javax.swing.*;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;

public class DisplayTable extends JFrame {

    static final String DATABASE_URL = "jdbc:derby://localhost:1527/countriesdb";
    static final String USERNAME = "nbuser";
    static final String PASSWORD = "nbuser";
    static final String QUERY = "SELECT * FROM Countries";
    
    private ResultSetTableModel tableModel;
    private JTable resultTable;
    private TableRowSorter<TableModel> sorter;
    
    private JTextArea queryArea;
    private JTextField filterText = new JTextField();
   
    private JLabel filterLabel = new JLabel("Filter:");
    private JButton filterButton = new JButton("Apply Filter");
     
    public DisplayTable() {
        

        try {
            tableModel = new ResultSetTableModel(DATABASE_URL, USERNAME, PASSWORD, QUERY);
            resultTable = new JTable(tableModel);     
           
            Box boxSouth = Box.createHorizontalBox();
            boxSouth.add(filterLabel);
            boxSouth.add(filterText);
            boxSouth.add(filterButton);
            filterButton.addActionListener(new FilterButtonListener());
            
            add(new JScrollPane(resultTable), BorderLayout.CENTER);
            add(boxSouth, BorderLayout.SOUTH);

            sorter = new TableRowSorter<TableModel>(tableModel);
            resultTable.setRowSorter(sorter);
    
            addWindowListener(new WindowCloseListener());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            tableModel.disconnectFromDatabase();
            System.exit(1);
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
        DisplayTable frame = new DisplayTable();
        frame.setTitle("Displaying Query Results");
        frame.setSize(500, 250);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

