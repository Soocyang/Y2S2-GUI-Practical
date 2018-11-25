/* 
*Student Name   : Soo Cia Yang
*Student ID     : 17WMD05652
*Tutotial Group : GP1
*Practical 6 Question 2
*--------------------------------------
*/

package da;

import domain.Programme;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class ProgrammeDA {

    private String host = "jdbc:derby://localhost:1527/collegedb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Programme";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String sqlQueryStr = "SELECT * FROM " + tableName;


    public ProgrammeDA() {
        createConnection();
    }

    /* P7Q2 */
    public ArrayList<Programme> getProgrammes() {
        
        ArrayList<Programme> progmList = new ArrayList<Programme>();
        
        try {
            stmt = conn.prepareStatement(sqlQueryStr);
            rs = stmt.executeQuery();
            while (rs.next()) {
                progmList.add(getCurrentRecord());
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return progmList;
    }

    public Programme getCurrentRecord() {
        Programme programme = null;
        try {
            programme = new Programme(rs.getString(1), rs.getString(2), rs.getString(3));
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return programme;
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
            if (found) {
                p = new Programme(code, rs.getString("Name"), rs.getString("Faculty"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return p;
    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);

            System.out.println("Connected");
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

    public static void main(String[] args) {
        ProgrammeDA progDA = new ProgrammeDA();
        ArrayList<Programme> progms = new ArrayList<Programme>();
        progms=progDA.getProgrammes();
        
        
        System.out.println(progms);
    }

}
