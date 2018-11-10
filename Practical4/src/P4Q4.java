/* 
@Student Name   : Soo Cia Yang
@Student ID     : 17WMD05652
@Tutotial Group : GP1
@Practical 4 Question 4
--------------------------------------
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class P4Q4 extends JFrame {

    private static final JPasswordField jtfPassword = new JPasswordField();
    private static final JPanel pane1 = new JPanel();
    private static final JPanel pane2 = new JPanel();
    private static final JPanel pane3 = new JPanel();
    private static final JLabel jlbEnterPass = new JLabel("Enter your password");
    private static final JButton jbtSubmit = new JButton("Submit");
    private static final JTextArea ta = new JTextArea(5, 35);

    public P4Q4() {

        ta.setEditable(false);
        ta.setLineWrap(true);
        jbtSubmit.addActionListener(new sumBtnListener());

        pane1.setLayout(new GridLayout(1, 2));
        pane2.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pane1.add(jlbEnterPass);
        pane1.add(jtfPassword);
        pane2.add(jbtSubmit);
        pane3.add(ta);

        add(pane1, BorderLayout.NORTH);
        add(pane2, BorderLayout.CENTER);
        add(pane3, BorderLayout.SOUTH);
        //Frame Component

    }

    public static void main(String[] args) {
        P4Q4 setPassword = new P4Q4();

        setPassword.setTitle("Set Password");
        setPassword.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPassword.pack();
        setPassword.setLocationRelativeTo(null);
        setPassword.setVisible(true);
    }

    public class sumBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            char[] passArr = jtfPassword.getPassword();
            try {

                Password pass = new Password(passArr);
                ta.setText("Congratulation! your password is valid");
                ta.setForeground(Color.BLUE);

            } catch (InvalidPasswordException ex) {
                jtfPassword.setText("");
                jtfPassword.requestFocusInWindow();
                ta.setForeground(Color.red);
                ta.setText(ex.getMessage());
                //ta.grabFocus();
            }

            //ta.setText(new String(jtfPassword.getPassword()));
        }

    }

}
