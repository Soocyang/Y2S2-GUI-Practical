/* 
*Student Name   : Soo Cia Yang
*Student ID     : 17WMD05652
*Tutotial Group : GP1
*Practical 7 Question 3
*--------------------------------------
*/

package ui;

import da.StudentTableModel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class SearchStudent extends JFrame {

    private StudentTableModel tableModel;
    private JTextField jtfCode = new JTextField();
    private TableRowSorter<TableModel> sorter;
    private JTable studentTable;

    public SearchStudent() {
        super("Student Information");
        add(jtfCode, BorderLayout.NORTH);
        jtfCode.addActionListener(new SearchListener());

        tableModel = new StudentTableModel();
        studentTable = new JTable(tableModel);
        sorter = new TableRowSorter<TableModel>(tableModel);
        studentTable.setRowSorter(sorter);
        add(new JScrollPane(studentTable));

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    private class SearchListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() != "") {
                String code = jtfCode.getText();
                tableModel.getRecord(code);
            }

        }

    }

    public static void main(String[] args) {
        SearchStudent ss = new SearchStudent();
    }
}
