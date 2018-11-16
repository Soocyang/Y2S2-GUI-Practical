/* 
@Student Name   : Soo Cia Yang
@Student ID     : 17WMD05652
@Tutotial Group : GP1
@Practical 3 Question 2
*/
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class P3Q2 extends JFrame {

    private final JPanel pane = new JPanel();
    private final JPanel pane2 = new JPanel();
    private final JButton btnCompute = new JButton("Compute Payment");
    //Text Field
    private final JTextField jtfInterestRate = new JTextField();
    private final JTextField jtfNumOfYears = new JTextField();
    private final JTextField jtfLoanAmount = new JTextField();
    private final JTextField jtfMonthlyPay = new JTextField();
    private final JTextField jtfTotalPay = new JTextField();

    public P3Q2() {

        pane.setBorder(new TitledBorder("Enter loan amount, interest rate, and year"));
        pane.setLayout(new GridLayout(5, 2));
        pane.add(new JLabel("Annual Interest Rate"));
        pane.add(jtfInterestRate);
        pane.add(new JLabel("Number of Years"));
        pane.add(jtfNumOfYears);
        pane.add(new JLabel("Loan Amount"));
        pane.add(jtfLoanAmount);
        pane.add(new JLabel("Monthly Payment"));
        pane.add(jtfMonthlyPay);
        pane.add(new JLabel("Total Payment"));
        pane.add(jtfTotalPay);
        
        jtfMonthlyPay.setEditable(false);
        jtfTotalPay.setEditable(false);

        pane2.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pane2.add(btnCompute);

        add(pane, BorderLayout.CENTER);
        add(pane2, BorderLayout.SOUTH);

        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double annInRate = Double.parseDouble(jtfInterestRate.getText());
                int numOfYear = Integer.parseInt(jtfNumOfYears.getText());
                double loanAmt = Double.parseDouble(jtfLoanAmount.getText());
                Loan newLoan = new Loan(annInRate, numOfYear, loanAmt);
                double monPayment = newLoan.getMonthlyPayment();
                double totalPayment = newLoan.getTotalPayment();
                
                jtfMonthlyPay.setText(String.format("%.2f", monPayment));
                jtfTotalPay.setText(String.format("%.2f", totalPayment));
                
            }

        });

        //Frame Component
        setTitle("Loan Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        //pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        P3Q2 testing = new P3Q2();
    }

}
