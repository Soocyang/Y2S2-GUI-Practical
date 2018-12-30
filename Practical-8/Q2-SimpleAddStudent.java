package servletexamples;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleAddStudent extends HttpServlet {

    private Connection conn;
    private PreparedStatement stmt;
    private String host = "jdbc:derby://localhost:1527/collegedb";
    private String user = "nbuser";
    private String password = "nbuser";

    @Override
    public void init() throws ServletException {
        initializeJdbc();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //Obtain parameters from client
        String id = request.getParameter("id");
        String ic = request.getParameter("ic");
        String name = request.getParameter("name");
        String level = request.getParameter("level");
        String progm = request.getParameter("programme");
        String yearOfStudy = request.getParameter("yearStudy");

        try {
            if (id.length() == 0 || ic.length() == 0) {
                out.println("Student ID and IC required.");
            } else {
                storeStudent(id, ic, name, level, progm, yearOfStudy);
                out.println("Student " + id + " has been added to the database");
            }
        } catch (Exception ex) {
            out.println("ERROR: " + ex.getMessage());
        } finally {
            out.close();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void initializeJdbc() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(host, user, password);
            stmt = conn.prepareStatement("INSERT INTO Student VALUES(?, ?, ?, ?, ?, ?)");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void storeStudent(String id, String ic, String name, String level, String progm, String yearOfStudy) throws SQLException {
        stmt.setString(1, id);
        stmt.setString(2, ic);
        stmt.setString(3, name);
        stmt.setString(4, level);
        stmt.setString(5, progm);
        stmt.setString(6, yearOfStudy);
        stmt.executeUpdate();

    }

}
