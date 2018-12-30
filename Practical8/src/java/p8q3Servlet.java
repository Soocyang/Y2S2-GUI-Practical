/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author User
 */
public class p8q3Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Loan stupidLoan;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet p8q3Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet p8q3Servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        double loanAmount = Double.parseDouble(request.getParameter("LoanAmount"));
        double interest = Double.parseDouble(request.getParameter("interest"));
        int yr = Integer.parseInt(request.getParameter("yr"));
        stupidLoan = new Loan( interest, yr, loanAmount);
        out.println("You entered the following data"+ "<br><br>");
        out.println("Loan amount: RM" + String.format("%.2f",loanAmount) + "<br>");
        out.println("Annual interest rate: " + String.format("%.2f",interest) + "<br>");
        out.println("Number of years:" + yr + "<br><br>");
        out.println("<form action=\"p8q3Servlet\" method=\"post\">");
        out.println("<input type=\"submit\" name=\"stupidButton\" value=\"Confirm\" />");
        out.println("</form>");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("Loan amount: RM" + String.format("%.2f",stupidLoan.getLoanAmount()) + "<br>");
        out.println("Annual interest rate: " + String.format("%.2f",stupidLoan.getAnnualInterestRate()) + "<br>");
        out.println("Number of years:" + stupidLoan.getNumberOfYears() + "<br>");
        out.println("Monthly Payment: RM" + "<strong>"+ String.format("%.2f",stupidLoan.getMonthlyPayment()) + "</strong><br>");
        out.println("Total Payment: RM" + "<strong>"+ String.format("%.2f",stupidLoan.getTotalPayment()) + "</strong><br>");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
