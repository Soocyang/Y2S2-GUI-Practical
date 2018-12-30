/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tarc
 */
public class p8q4Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        //Obtain parameters from the client
        String id = request.getParameter("id");
        String ic = request.getParameter("ic");
        String name = request.getParameter("uname");
        String lv = request.getParameter("level");
        String prog = request.getParameter("prog");
        String year = request.getParameter("yr");
        
        Cookie cookieName = new Cookie("name", name);
        response.addCookie(cookieName);
        
        out.println("Student ID: <b>" + id + "</b><br>");
        out.println("IC number: <b>" + ic + "</b><br>");
        out.println("Name: <b>" + name + "</b><br>");
        out.println("Programme code:<b>" + prog + "</b><br>");
        out.println("Year of study: <b>" + year + "</b><br>");
        out.println("<br><a href = \"/Practical8/p8q4ThirdServlet\" style=\"color: #C71585\">Click here</a>");
        out.close();
    }
}
