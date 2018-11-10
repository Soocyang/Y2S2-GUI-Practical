/* 
@Student Name   : Soo Cia Yang
@Student ID     : 17WMD05652
@Tutotial Group : GP1
@Practical 4 Question 1
--------------------------------------
To test the program... The Key Binding for  :
        Add Operation is "Alt + A"
        Subtract Operation is "Alt + S"
        Multiply Operation is "Alt + M"
        Divide Operation is "Alt + D"

 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class P4Q1 extends JFrame {

    private final JPanel pane1 = new JPanel();
    private final JPanel pane2 = new JPanel();
    private final JTextField jtfFirstNum = new JTextField();
    private final JTextField jtfSecondNum = new JTextField();
    private final JTextField jtfResult = new JTextField();
    private final JButton jbtAdd = new JButton("Add");
    private final JButton jbtSubtract = new JButton("Subtract");
    private final JButton jbtMultiply;
    private final JButton jbtDivide = new JButton("Divide");

    public P4Q1() {
        this.jbtMultiply = new JButton("Multiply");

        //Panel 1
        pane1.setLayout(new GridLayout(3, 2));
        pane1.add(new JLabel("First Number"));
        pane1.add(jtfFirstNum);
        pane1.add(new JLabel("Second Number"));
        pane1.add(jtfSecondNum);
        pane1.add(new JLabel("Result"));
        pane1.add(jtfResult);

        //Panel 2
        pane2.setLayout(new FlowLayout());
        pane2.add(jbtAdd);
        pane2.add(jbtSubtract);
        pane2.add(jbtMultiply);
        pane2.add(jbtDivide);

        //Add Panel to Frame
        add(pane1, BorderLayout.CENTER);
        add(pane2, BorderLayout.SOUTH);

        //Set Result Field Uneditable
        jtfResult.setEditable(false);

        //Add listener
        jbtAdd.addActionListener(new calcBtnListener());
        jbtSubtract.addActionListener(new calcBtnListener());
        jbtMultiply.addActionListener(new calcBtnListener());
        jbtDivide.addActionListener(new calcBtnListener());

        //Add 
        jbtAdd.setMnemonic(KeyEvent.VK_A);
        jbtSubtract.setMnemonic(KeyEvent.VK_S);
        jbtMultiply.setMnemonic(KeyEvent.VK_M);
        jbtDivide.setMnemonic(KeyEvent.VK_D);

        //Frame Component
        setTitle("Simple Calculator");
        setSize(350, 180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pack();

        setVisible(true);
    }

    public static void main(String[] args) {

        P4Q1 p3Q4 = new P4Q1();

    }

    private class calcBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                double firstNum = Double.parseDouble(jtfFirstNum.getText());
                double secondNum = Double.parseDouble(jtfSecondNum.getText());

                if (e.getSource() == jbtAdd) {
                    double addAns = firstNum + secondNum;
                    jtfResult.setText(String.format("%.2f", addAns));

                } else if (e.getSource() == jbtSubtract) {
                    double subAns = firstNum - secondNum;
                    jtfResult.setText(String.format("%.2f", subAns));

                } else if (e.getSource() == jbtMultiply) {
                    double mulAns = firstNum * secondNum;
                    jtfResult.setText(String.format("%.2f", mulAns));

                } else if (e.getSource() == jbtDivide) {
                    double divAns = firstNum / secondNum;
                    jtfResult.setText(String.format("%.2f", divAns));

                }
            } catch (NumberFormatException ex) {
                   JOptionPane.showMessageDialog(null, "Incorrect input: integer or float number required", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                   jtfFirstNum.setText("");
                   jtfSecondNum.setText("");
                   jtfFirstNum.requestFocusInWindow();
            }

        }

    }

}
