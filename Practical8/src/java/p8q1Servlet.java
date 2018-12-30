/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tarc
 */
public class p8q1Servlet extends HttpServlet {

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
        out.println("Student ID: <b>" + id + "</b><br>");
        out.println("IC number: <b>" + ic + "</b><br>");
        out.println("Name: <b>" + name + "</b><br>");
        out.println("Level: <b>" + lv + "</b><br>");
        out.println("Programme code:<b>" + prog + "</b><br>");
        out.println("Year of study: <b>" + year + "</b><br>");
        out.close();
    }
}
