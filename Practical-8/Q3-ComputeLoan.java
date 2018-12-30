package servletexamples;

import domain.Loan;
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
public class ComputeLoan extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

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
        // Obtain data from the form
        String loanAmount = request.getParameter("loanAmount");
        String intRate = request.getParameter("intRate");
        String numOfYear = request.getParameter("numOfYear");

        if (loanAmount.length() == 0 || intRate.length() == 0 || numOfYear.length() == 0) {
            out.println("Please fill up all the field. All field are required.");
        } else {
            // ask for confirmation
            double amt = Double.parseDouble(loanAmount);
            double rate = Double.parseDouble(intRate);
            int duration = Integer.parseInt(numOfYear);
            Loan loan = new Loan(rate, duration, amt);

            out.println("You entered the following data");
            out.println("<p>Loan Amount: RM" + loanAmount);
            out.println("<br>Annual Interest Rate: " + intRate);
            out.println("<br>Number of Years: " + numOfYear);

            // Set the action for processing the answers
            out.println("<p><form method=\"post\" action=ComputeLoan>");

            // Set hidden values
            out.println("<p><input type=\"hidden\" value=" + loan.getLoanAmount() + " name=\"loanAmount\">");
            out.println("<p><input type=\"hidden\" value=" + loan.getAnnualInterestRate() + " name=\"intRate\">");
            out.println("<p><input type=\"hidden\" value=" + loan.getNumberOfYears() + " name=\"numOfYear\">");

            out.println("<p><input type=\"submit\" value=\"Confirm\" >");
            out.println("</form>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String loanAmount = request.getParameter("loanAmount");
        String intRate = request.getParameter("intRate");
        String numOfYear = request.getParameter("numOfYear");

        double amt = Double.parseDouble(loanAmount);
        double rate = Double.parseDouble(intRate);
        int duration = Integer.parseInt(numOfYear);
        Loan loan = new Loan(rate, duration, amt);

        // Set hidden values
        out.println("<p>Loan Amount: RM" + loan.getLoanAmount());
        out.println("<br>Annual Interest Rate: " + loan.getAnnualInterestRate());
        out.println("<br>Number of Years: " + loan.getNumberOfYears());
        out.println("<br>Monthly Payment: <b>RM" + loan.getMonthlyPayment() + "</b>");
        out.println("<br>Total Payment: <b>RM" + loan.getTotalPayment() + "</b>");

    }

}
