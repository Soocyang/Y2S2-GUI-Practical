/* 
@Student Name   : Soo Cia Yang
@Student ID     : 17WMD05652
@Tutotial Group : GP1
@Practical 1 Question 6 & 7
*/

import java.awt.*;
import javax.swing.*;


public class P1Q6 extends JFrame{
    public P1Q6 (){
        //add layout
        
        //P1Q6
//        //add button
//        JPanel p1 = new JPanel(new GridLayout(1,2));
//        p1.add(new JButton("Button 1"));
//        p1.add(new JButton("Button 2"));
//        //add button
//        JPanel p2 = new JPanel(new GridLayout(1,2));
//        p2.add(new JButton("Button 3"));
//        p2.add(new JButton("Button 4"));
        
        //P1Q7
        JPanel p1 = new P1Q7("Button 1", "Button 2");
        JPanel p2 = new P1Q7("Button 3", "Button 4");

        add(p1,BorderLayout.SOUTH);
        add(p2,BorderLayout.CENTER);
              
        //add frame components
        setTitle("Q6 BUTTONS");
        setSize(300,250);
        //pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        P1Q6 p1Q6 = new P1Q6();
    }
}
