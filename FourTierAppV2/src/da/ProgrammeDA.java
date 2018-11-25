package da;

import domain.Programme;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class ProgrammeDA {

    private String host = "jdbc:derby://localhost:1527/collegedb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Programmes";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String sqlQueryStr = "SELECT * FROM " + tableName;
    
    public ProgrammeDA() {
        createConnection();
    }
    /* P7Q2 */
    public ArrayList<Programme> getProgrammes() {
         throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public Programme getRecord(String code) {
        Programme p = null;
        try {
            rs.beforeFirst();
            boolean found = false;
            while (!found && rs.next()) {
                if (code.equals(rs.getString("Code"))) {
                    found = true;
                }
            }
            if (found)
                p = new Programme(code, rs.getString("Name"), rs.getString("Faculty"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return p;
    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void shutDown() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
