
package Practical3;

import java.awt.*;
import java.awt.event.*;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javax.swing.*;
import javax.swing.border.*;

public class p3q2 extends JFrame{
    
    private JLabel labelAnnualRate = new JLabel("Annual Interest Rate");
    private JLabel labelNoYear = new JLabel("Number of Years");
    private JLabel labelLoanAmount = new JLabel("Loan Amount");
    private JLabel labelMonthlyPayment = new JLabel("MonthlyPayment");
    private JLabel labelTotalPayment = new JLabel("Total Payment");
    private JTextField jtf1 = new JTextField(30);
    private JTextField jtf2 = new JTextField(30);
    private JTextField jtf3 = new JTextField(30);
    private JTextField jtf4 = new JTextField(30);
    private JTextField jtf5 = new JTextField(30);
    private JButton bb = new JButton("Compute Payment");
    
    public p3q2(){
        JPanel jp1 = new JPanel(new GridLayout(5,2));
        JPanel jp2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        jp1.setBorder(new LineBorder(Color.black, 2));
      
        Border empty = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border blackLine = BorderFactory.createLineBorder(Color.black);
        CompoundBorder line = new CompoundBorder(empty, blackLine);
        Border grid1Border = BorderFactory.createTitledBorder(line, "Enter loan amount, interest rate, and years");
        jp1.setBorder(grid1Border);
        
        add(jp1,BorderLayout.CENTER);
        add(jp2,BorderLayout.SOUTH);
       
        jp1.add(labelAnnualRate);
        jp1.add(jtf1);
        jp1.add(labelNoYear);
        jp1.add(jtf2);
        jp1.add(labelLoanAmount);
        jp1.add(jtf3);
        jp1.add(labelMonthlyPayment);
        jtf4.setEditable(false);
        jp1.add(jtf4);
        jp1.add(labelTotalPayment);
        jtf5.setEditable(false);
        jp1.add(jtf5);
        
        jp2.add(bb);
        bb.addActionListener(new ButtonListener());
   
        setSize(500,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    
     private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double annualRate = Double.parseDouble(jtf1.getText());
            int noYear = Integer.parseInt(jtf2.getText());
            double loanAmount = Double.parseDouble(jtf3.getText());
            
            Loan ll = new Loan(annualRate, noYear, loanAmount);
            double monthlyPayment = ll.getMonthlyPayment();
            double totalPayment = ll.getTotalPayment();   
            jtf4.setText(String.format("%.2f",monthlyPayment));
            jtf5.setText(String.format("%.2f",totalPayment));
        }
    
    }
    
    public static void main(String[] args){
        new p3q2();
    }
    
    
    
}
