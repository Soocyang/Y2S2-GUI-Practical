/* 
@Student Name   : Soo Cia Yang
@Student ID     : 17WMD05652
@Tutotial Group : GP1
@Practical 1 Question 7
*/
import java.awt.*;
import javax.swing.*;


public class P1Q7 extends JPanel{
    public P1Q7() {
    }
    public P1Q7(String btn1, String btn2) {
        setLayout(new GridLayout(1,2));
        add(new JButton(btn1));
        add(new JButton(btn2));
        
    }

}
