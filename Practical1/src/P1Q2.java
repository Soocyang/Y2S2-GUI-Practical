/* 
@Student Name   : Soo Cia Yang
@Student ID     : 17WMD05652
@Tutotial Group : GP1
@Practical 1 Question 2
*/

import javax.swing.*;

public class P1Q2 extends JFrame{
    private JButton btt = new JButton("Hello");
    public P1Q2() {
        add(btt);
        setTitle("One Frame");
        setSize(500,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new P1Q2();
    }
}
