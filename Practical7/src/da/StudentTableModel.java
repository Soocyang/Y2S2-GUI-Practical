/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import java.sql.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class StudentTableModel extends AbstractTableModel {

    static final String url = "jdbc:derby://localhost:1527/collegedb";
    static final String username = "nbuser";
    static final String password = "nbuser";
    String query = "SELECT * FROM STUDENT";
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private ResultSetMetaData metaData;
    private int numberOfRows = 2;

    public StudentTableModel() {
        try {
            String query = "SELECT * FROM STUDENT";
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            setQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public StudentTableModel(String code) {
        try {

            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            setQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int getColumnCount() {

        try {
            return metaData.getColumnCount();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public String getColumnName(int column) {

        try {
            return metaData.getColumnName(column + 1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    @Override
    public int getRowCount() {
        return numberOfRows;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            rs.absolute(rowIndex + 1);
            return rs.getObject(columnIndex + 1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public void setQuery(String query) {
        try {
            rs = stmt.executeQuery(query);
            metaData = rs.getMetaData();

            // determine number of rows in ResultSet
            rs.last();                      // move to last row
            numberOfRows = rs.getRow();     // get row number

            // notify JTable that model has changed
            fireTableStructureChanged();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void setQueryProgmCode(String code) {
        try {
            rs = stmt.executeQuery(query + " WHERE ProgrammeCode = \'" + code + "\'");
            metaData = rs.getMetaData();

            rs.last();
            numberOfRows = rs.getRow();

            fireTableStructureChanged();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void getRecord(String code) {
        if (code == "") {
            setQuery(query);
        } else {
            setQueryProgmCode(code);
        }
    }

    public static void main(String[] args) {
        StudentTableModel tableModel = new StudentTableModel("IA");
        JTable jtable = new JTable(tableModel);
        TableRowSorter sorter = new TableRowSorter<TableModel>(tableModel);
        jtable.setRowSorter(sorter);
        JFrame frame = new JFrame();
        frame.add(new JScrollPane(jtable));
        frame.setSize(500, 250);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
