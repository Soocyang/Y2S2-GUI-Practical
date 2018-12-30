package servletexamples;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayStudentDetail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String id = request.getParameter("id");
            String ic = request.getParameter("ic");
            String name = request.getParameter("name");
            String level = request.getParameter("level");
            String progm = request.getParameter("programme");
            String yearOfStudy = request.getParameter("yearStudy");
            
            /* TODO output your page here. You may use following sample code. */
            out.println("Student ID: <b>" + id + "</b><br>");
            out.println("IC number: <b>" + ic + "</b><br>");
            out.println("Name : <b>" + name + "</b><br>");
            out.println("Level: <b>" + level + "</b><br>");
            out.println("Programme code: <b>" + progm + "</b><br>");
            out.println("Year of study: <b>" + yearOfStudy + "</b><br>");
            out.close();
        }
    }
}
