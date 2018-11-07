/* 
@Student Name   : Soo Cia Yang
@Student ID     : 17WMD05652
@Tutotial Group : GP1
@Practical 3 Question 3
--------------------------------------
To test the program... UserName is "You"  Password is "password"
*/
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class P3Q3 extends JFrame {

    private final String fakeUserName = "You";
    private final char[] fakePassword = new char[]{'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
    private final JPanel pane1 = new JPanel();
    private final JPanel pane2 = new JPanel();
    private final JTextField jtfUserName = new JTextField();
    private final JPasswordField jpfPass = new JPasswordField();
    private final JButton jbtLogin = new JButton("Login");
    private final JButton jbtReset = new JButton("Reset");

    public P3Q3() {

        //Panel 1
        pane1.setLayout(new GridLayout(2, 2));
        pane1.add(new JLabel("User name"));
        pane1.add(jtfUserName);
        pane1.add(new JLabel("Password"));
        pane1.add(jpfPass);

        //Panel 2
        pane2.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pane2.add(jbtLogin);
        pane2.add(jbtReset);

        //adding panel
        add(pane1, BorderLayout.CENTER);
        add(pane2, BorderLayout.SOUTH);

        //adding listener
        jbtLogin.addActionListener(new btnListener());
        jbtReset.addActionListener(new btnListener());

        //Frame Component
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 180);
        setLocationRelativeTo(null);
        //pack();
        setVisible(true);

    }

    public static void main(String[] args) {
        P3Q3 test = new P3Q3();
    }

    private class btnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == jbtLogin) {
                if (checkPassword()) {
                    JOptionPane.showMessageDialog(null, "Login Successful !");
                    //Proceed to Loan Calculator
                    P3Q2 testing = new P3Q2();

                } else {
                    JOptionPane.showMessageDialog(null, "Failed to Login ! Please enter correct username and password.");
                }

            } else if (e.getSource() == jbtReset) {
                jtfUserName.setText("");
                jpfPass.setText("");
                jtfUserName.requestFocusInWindow();
            }

        }

    }

    //Checking Password
    private boolean checkPassword() {
        boolean x = false;

        if (jtfUserName.getText().equals(fakeUserName) && Arrays.equals(jpfPass.getPassword(), fakePassword)) {
            x = true;
        }

        return x;
    }

}
