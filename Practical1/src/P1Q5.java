/* 
@Student Name   : Soo Cia Yang
@Student ID     : 17WMD05652
@Tutotial Group : GP1
@Practical 1 Question 5
*/

import java.awt.*;
import javax.swing.*;


public class P1Q5 extends JFrame{
       
    public P1Q5() {
        //add layout
        setLayout(new FlowLayout());
        pack();
        //add button
        JPanel p1 = new JPanel();
        p1.add(new JButton("Button 1"));
        p1.add(new JButton("Button 2"));
        //add button
        JPanel p2 = new JPanel();
        p2.add(new JButton("Button 3"));
        p2.add(new JButton("Button 4"));
        
        add(p1);
        add(p2);
              
        //add frame components
        setTitle("BUTTONS");
        //setSize(300,250);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new P1Q5();
    }
}
