/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Chun
 */
public class p8q2Servlet extends HttpServlet {

    private Connection conn;
    private PreparedStatement pstmt;
    private String host = "jdbc:derby://localhost:1527/collegedb";
    private String user = "nbuser";
    private String password = "nbuser";
    @Override
    public void init() throws ServletException {
       try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(host, user, password);
            pstmt = conn.prepareStatement("INSERT INTO Student VALUES(?, ?, ?, ?, ?, ?)");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        ResultSet rs = null;
        try {
            String id = request.getParameter("id");
            String ic = request.getParameter("ic");
            String name = request.getParameter("uname");
            String lv = request.getParameter("level");
            String prog = request.getParameter("prog");
            String year = request.getParameter("yr");
            
            pstmt.setString(1, id);
            pstmt.setString(2, ic);
            pstmt.setString(3, name);
            pstmt.setString(4, lv);
            pstmt.setString(5, prog);
            pstmt.setString(6, year);
           
            pstmt.executeUpdate();
            out.println("Student " + id + " has been added to the database");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }


}
