/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtableexamples;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class TestTableModel extends JFrame {
  // Create table column names
  private String[] columnNames ={"Country", "Capital", "Population in Millions", "Democracy"};
  
  // Create table data
  private Object[][] data = {
    {"USA", "Washington DC", 280, true},
    {"Canada", "Ottawa", 32, true},
    {"Malayisa" ,"Kuala Lumpur", 300, true}
  };

  // Create a model
  private DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);

  // Create a table
  private JTable jTable1 = new JTable(tableModel);

  private JButton jbt = new JButton("Click Me");
  
  public TestTableModel() {
    add(new JScrollPane(jTable1));
    add(jbt, BorderLayout.SOUTH);
    jbt.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            tableModel.addRow(new Object[]{"France", "Paris", 60, true});
            tableModel.insertRow(0, new Object[]{"India", "New Delhi", 1046, true});
            tableModel.removeRow(1);
            tableModel.addColumn("Area");
            tableModel.setValueAt(10, 0, 4);
            tableModel.setValueAt(20, 1, 4);
            tableModel.setValueAt(30, 2, 4);
        }
       } );
      
  }

  //Main method
  public static void main(String[] args) {
    JFrame frame = new TestTableModel();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("TestTableModel");
    frame.setSize(400,320);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}



