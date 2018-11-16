/* 
@Student Name   : Soo Cia Yang
@Student ID     : 17WMD05652
@Tutotial Group : GP1
@Practical 3 Question 5

 */

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class P3Q5 extends JFrame {

    private static final Font font = new Font("Courier", Font.BOLD, 20);
    private static final JLabel jlbTitle = new JLabel("Fund Transfers");

    private static final JLabel jlbFromTeller = new JLabel("From Teller");
    private static final JTextField jtfFromTeller = new JTextField();
    private static final JLabel jlbToTeller = new JLabel("To Teller");
    private static final JTextField jtfToTeller = new JTextField();

    private static final JTextField[][] jtfArrayForPane2 = new JTextField[7][3];

    private static final JButton jbnOk = new JButton("OK");
    private static final JButton jbnCancel = new JButton("Cancel");

    private static final JPanel paneTeller = new JPanel();
    private static final JPanel pane1 = new JPanel();
    private static final JPanel pane2 = new JPanel();
    private static final JPanel pane3 = new JPanel();

    private static final String[] tableHeader = {"Denomination", "Quantity", "Value"};
    private static final String[] denomiationNum = {"", "100", "50", "10", "5", "1", "Total"};

//    private static final String getDenot100;
//    private static final String getDenot50;
//    private static final String getDenot10;
//    private static final String getDenot5;
//    private static final String getDenot1;
    public P3Q5() {

        settingPanel1();
        settingPanel2();
        processingPanel2();
        settingPanel3();

        //Adding Panell
        add(pane1, BorderLayout.NORTH);
        add(pane2, BorderLayout.CENTER);
        add(pane3, BorderLayout.SOUTH);

        //Add Frame Component
        setTitle("Transfer funds");
        setSize(600, 500);
        //pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        P3Q5 p3Q5 = new P3Q5();
    }

    private static void settingPanel1() {
        //Settingup Panel Teller
        paneTeller.setLayout(new GridLayout(2, 2));

        paneTeller.add(jlbFromTeller);
        jlbFromTeller.setHorizontalAlignment(SwingConstants.RIGHT);
        paneTeller.add(jtfFromTeller);

        paneTeller.add(jlbToTeller);
        jlbToTeller.setHorizontalAlignment(SwingConstants.RIGHT);
        paneTeller.add(jtfToTeller);

        //Setting up Panel 1
        jlbTitle.setFont(font);
        jlbTitle.setAlignmentX(CENTER_ALIGNMENT);
        pane1.setLayout(new BoxLayout(pane1, BoxLayout.Y_AXIS));

        pane1.add(jlbTitle);
        pane1.add(paneTeller);
    }

    private static void settingPanel2() {
        //Setting up Panel 2
        pane2.setLayout(new GridLayout(7, 3));
        for (int i = 0; i < jtfArrayForPane2.length; i++) {                       //THIS IS TAT 7 ROWSS
            for (int j = 0; j < jtfArrayForPane2[3].length; j++) {                       //THIS IS TAT 3 COLUMNS
                jtfArrayForPane2[i][j] = new JTextField();
                jtfArrayForPane2[i][j].setHorizontalAlignment(SwingConstants.RIGHT);
                jtfArrayForPane2[i][j].setFont(new Font("Courier", Font.BOLD, 12));

                pane2.add(jtfArrayForPane2[i][j]);

                if (i == 0) {
                    jtfArrayForPane2[i][j].setBorder(null);
                    jtfArrayForPane2[i][j].setText(tableHeader[j]);
                    jtfArrayForPane2[i][j].setHorizontalAlignment(SwingConstants.CENTER);

                }

                if (j == 0) {
                    jtfArrayForPane2[i][j].setBorder(null);
                }

                if (j == 0 || j == 2) {
                    jtfArrayForPane2[i][j].setEditable(false);

                }

                if (i == 0 || i == 6) {
                    jtfArrayForPane2[i][j].setEditable(false);
                }

                if (i == 6 && j == 1) {
                    jtfArrayForPane2[i][j].setBorder(null);
                }

                if (i != 0 && j == 0) {
                    jtfArrayForPane2[i][j].setText(denomiationNum[i]);

                }
            }
        }
    }

    private static void processingPanel2() {

        jtfArrayForPane2[6][1].setText(null);

        //Getting Input
//        KeyEventListener kyl = new KeyEventListener();
//
//        JTextField denot100jtf = jtfArrayForPane2[1][1];
//        denot100jtf.addKeyListener();
        for (int i = 1; i < 6; i++) {
            jtfArrayForPane2[i][1].addKeyListener(new KeyEventListener());
            //Displaying Output
            jtfArrayForPane2[i][2].addKeyListener(new KeyEventListener());

        }

        //Displaying Total
        //jtfArrayForPane2[6][2].setText("Total Is Here");
    }

    private static void settingPanel3() {
        //Settingup panel 3
        pane3.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pane3.add(jbnOk);
        pane3.add(jbnCancel);

    }

    private static class KeyEventListener implements KeyListener {

        int numOfDeOf100;
        int numOfDeOf50;
        int numOfDeOf10;
        int numOfDeOf5;
        int numOfDeOf1;

        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (!((c >= '0') && (c <= '9')
                    || (c == KeyEvent.VK_BACK_SPACE)
                    || (c == KeyEvent.VK_DELETE))) {
//                getToolkit().beep();
                e.consume();
            }

        }

        @Override
        public void keyPressed(KeyEvent e) {
                
        }

        @Override
        public void keyReleased(KeyEvent e) {

            if (e.getSource() == jtfArrayForPane2[1][1]) {
                jtfArrayForPane2[1][2].setText(String.format("%.2f", Double.parseDouble(jtfArrayForPane2[1][1].getText()) * 100));
            } else if (e.getSource() == jtfArrayForPane2[2][1]) {
                jtfArrayForPane2[2][2].setText(String.format("%.2f", Double.parseDouble(jtfArrayForPane2[2][1].getText()) * 50));
            } else if (e.getSource() == jtfArrayForPane2[3][1]) {
                jtfArrayForPane2[3][2].setText(String.format("%.2f", Double.parseDouble(jtfArrayForPane2[3][1].getText()) * 10));
            } else if (e.getSource() == jtfArrayForPane2[4][1]) {
                jtfArrayForPane2[4][2].setText(String.format("%.2f", Double.parseDouble(jtfArrayForPane2[4][1].getText()) * 5));
            } else if (e.getSource() == jtfArrayForPane2[5][1]) {
                jtfArrayForPane2[5][2].setText(String.format("%.2f", Double.parseDouble(jtfArrayForPane2[5][1].getText())));
            }
            
            jtfArrayForPane2[6][2].setText(String.format("%.2f", (Double.parseDouble(jtfArrayForPane2[1][1].getText()) * 100)
                    + (Double.parseDouble(jtfArrayForPane2[2][1].getText()) * 50)
                    + (Double.parseDouble(jtfArrayForPane2[3][1].getText()) * 10)
                    + (Double.parseDouble(jtfArrayForPane2[4][1].getText()) * 5)
                    + (Double.parseDouble(jtfArrayForPane2[5][1].getText()))));

            

        }
    }

    private static class BtnActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }

}
