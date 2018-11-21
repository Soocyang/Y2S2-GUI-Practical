/* 
*Student Name   : Soo Cia Yang
*Student ID     : 17WMD05652
*Tutotial Group : GP1
*Practical 5 Question 3
*--------------------------------------
*/

package da;

import domain.Programme;
import domain.Student;
import java.sql.*;
import javax.swing.*;
import control.MaintainProgrammeControl;

/**
 *
 * @author User
 */
public class StudentDA {

    private String host = "jdbc:derby://localhost:1527/collegedb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Student";
    private Connection conn;
    private PreparedStatement stmt;
    private ProgrammeDA progDA = new ProgrammeDA();
    //private MaintainProgrammeControl MPC;

    public StudentDA() {
        createConnection();
    }

    public Student getRecord(String id) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE ID = ?";
        Student student = null;

        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String progmCode = rs.getString("ProgrammeCode");
                Programme programme = progDA.getRecord(progmCode);

                //Programme progm = progDA.getRecord(rs.getString("ProgrammeCode"));
                student = new Student(id, rs.getString("IC"), rs.getString("Name"), rs.getString("Level").charAt(0), programme, rs.getInt("Yr"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        return student;
    }

    public void addRecord(Student student) {

        String insertStr = "INSERT INTO " + tableName + " VALUES(?, ?, ?, ?, ?, ?)";

        try {
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, student.getId());
            stmt.setString(2, student.getIc());
            stmt.setString(3, student.getName());
            stmt.setString(4, String.valueOf(student.getLevel()));
            stmt.setObject(5, student.getProgramme().getCode());
            stmt.setInt(6, student.getYear());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Student successful registered.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void updateRecord(Student student) {
        String updateStr = "UPDATE " + tableName + " SET IC = ?, NAME = ?, LEVEL = ?, PROGRAMMECODE = ?, YR = ? WHERE ID = ?";

        try {
            stmt = conn.prepareStatement(updateStr);
            stmt.setString(1, student.getIc());
            stmt.setString(2, student.getName());
            stmt.setString(3, String.valueOf(student.getLevel()));
            stmt.setString(4, student.getProgramme().getCode());
            stmt.setInt(5, student.getYear());
            stmt.setString(6, student.getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Student " + student.getName() + "'s record has been updated.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void deleteRecord(Student student) {
        String deleteStr = "DELETE FROM " + tableName + " WHERE id = ?";

        try {
            stmt = conn.prepareStatement(deleteStr);
            stmt.setString(1, student.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Student \"" + student.getName() + "\" has been deleted.", null, JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }

    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");

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
        StudentDA da = new StudentDA();
        Student student = da.getRecord("12WAD34567");
        System.out.println(student);
    }

}
