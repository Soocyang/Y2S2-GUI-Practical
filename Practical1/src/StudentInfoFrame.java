/* 
@Student Name   : Soo Cia Yang
@Student ID     : 17WMD05652
@Tutotial Group : GP1
@Practical 1 Questions 3 & 4
*/
import java.awt.*;
import javax.swing.*;

public class StudentInfoFrame extends JFrame{
    
    public StudentInfoFrame(){
        //add layout
        setLayout(new GridLayout(4,2));
                      
        //add label and text
        add(new JLabel("Registration Number :  "));
        add(new JTextField(10));
        add(new JLabel("Name   :  "));
        add(new JTextField(15));
        add(new JLabel("Program code  :  "));
        add(new JTextField(10));
        
        //add frame components
        setTitle("Student Information");
        //setSize(300,250);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        //add button
        add(new JButton("Summit"));
        
    }
    public static void main(String[] args) {
        new StudentInfoFrame();
    }
}
