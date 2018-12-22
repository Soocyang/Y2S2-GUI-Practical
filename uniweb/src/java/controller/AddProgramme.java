package controller;

import entity.Programme;
import java.io.*;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.transaction.UserTransaction;

public class AddProgramme extends HttpServlet {
    @PersistenceContext EntityManager em;
    @Resource UserTransaction utx;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String faculty = request.getParameter("faculty");
        try {
            if (code.length() == 0 || name.length() == 0) {
                out.println("Programme code and name are required.");
            } else {
                Programme programme = new Programme(code, name, faculty);
                utx.begin();
                em.persist(programme);
                utx.commit();
                out.println("New programme " + code + " " + name + " from the faculty "
                        + faculty + " has been added to the database.");
                Query query = em.createNamedQuery("Programme.findAll");
                List<Programme> list = query.getResultList();
                request.setAttribute("programmeList", list);
                RequestDispatcher rd = request.getRequestDispatcher("ViewProgrammes.jsp");
                rd.forward(request, response);
            }
        } catch (Exception ex) {
            out.println("ERROR: " + ex.getMessage());
            StackTraceElement[] arr = ex.getStackTrace();
            for (int i = 0; i < arr.length; ++i) {
                out.println(arr[i].getClassName() + ": " + arr[i].getLineNumber() + ": " + 
                        arr[i].toString()+"<br>");
            }
        } finally {
            out.close();
        }
    }
}
