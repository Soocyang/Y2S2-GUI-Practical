/* 
@Student Name   : Soo Cia Yang
@Student ID     : 17WMD05652
@Tutotial Group : GP1
@Practical 2 Question 1 & 2 & 3
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class P2Q1 extends JFrame {

    private final JLabel colorLabel = new JLabel("COLOR");
    private final JButton jbtRed = new JButton("Red");
    private final JButton jbtBlue = new JButton("Blue");
    private final JButton jbtGreen = new JButton("Green");
//    private final JPanel topPanel = new JPanel();
//    private final JPanel bottomPanel = new JPanel();

    public P2Q1() {
        //Label
        colorLabel.setFont(new Font("Cambria", Font.BOLD, 20));
        colorLabel.setHorizontalAlignment(JLabel.CENTER);
        //add label
        add(colorLabel);

        //Create Panel
        JPanel panB = new JPanel();
        panB.add(jbtRed);
        panB.add(jbtBlue);
        panB.add(jbtGreen);
        panB.setBorder(new TitledBorder("Buttons"));

        add(panB, BorderLayout.SOUTH);

        jbtRed.setBackground(Color.red);
        jbtBlue.setBackground(Color.blue);
        jbtGreen.setBackground(Color.green);
        jbtRed.setForeground(Color.white);
        jbtBlue.setForeground(Color.white);
        jbtGreen.setForeground(Color.white);

        //Add Listener Q1
//        jbtRed.addActionListener(new redBtnListener());
//        jbtBlue.addActionListener(new blueBtnListener());
//        jbtGreen.addActionListener(new greenBtnListener());
        //Add Listener Q2
//        jbtRed.addActionListener(new btnListener());
//        jbtBlue.addActionListener(new btnListener());
//        jbtGreen.addActionListener(new btnListener());

        //AnonymousInnerClass Q3
        jbtRed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                colorLabel.setForeground(Color.RED);
            }
        });
        
        jbtBlue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                colorLabel.setForeground(Color.BLUE);
            }
        });
        
        jbtGreen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                colorLabel.setForeground(Color.GREEN);
            }
        });

        //ADD FRAME COMPONENT
        setTitle("Primary Colors");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        P2Q1 test = new P2Q1();
    }

    //create action listenr class for each button
    private class redBtnListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            colorLabel.setForeground(Color.RED);
        }
    }

    private class blueBtnListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            colorLabel.setForeground(Color.BLUE);
        }
    }

    private class greenBtnListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            colorLabel.setForeground(Color.GREEN);
        }
    }

    //create action litener class for all buttons
    private class btnListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jbtRed) {
                colorLabel.setForeground(Color.RED);
            } else if (e.getSource() == jbtBlue) {
                colorLabel.setForeground(Color.BLUE);
            } else if (e.getSource() == jbtGreen) {
                colorLabel.setForeground(Color.GREEN);
            }

        }

    }
}
