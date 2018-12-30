package Practical3;

import javax.swing.*;
import java.awt.*;

public class p3q1 extends JFrame{

    public p3q1(){
        ImageIcon icon = new ImageIcon("grapes.gif");
      
        JLabel jl1 = new JLabel("Grapes", icon, SwingConstants.LEFT);
        JLabel jl2 = new JLabel("Grapes", icon, SwingConstants.CENTER);
        JLabel jl3 = new JLabel("Grapes", icon, SwingConstants.RIGHT);
        
        JLabel j1 = new JLabel("Grapes", icon, SwingConstants.LEFT);
        JLabel j2 = new JLabel("Grapes", icon, SwingConstants.CENTER);
        JLabel j3 = new JLabel("Grapes", icon, SwingConstants.RIGHT);
       
        JLabel gg = new JLabel("Grapes");
        
        add(jl1);
        add(jl2);
        add(jl3);
        
        add(j1);
        add(j2);
        add(j3);
        
        createFrame("Left" ,jl1);
        createFrame("Center" ,jl2);
        createFrame("Right" ,jl3);     
        
        createFrame("Left" ,j1);
        createFrame("Center" ,j2);
        createFrame("Right" ,j3);   
        
        j1.setHorizontalTextPosition(JLabel.LEFT);
        j2.setHorizontalTextPosition(JLabel.CENTER);
        j3.setHorizontalTextPosition(JLabel.RIGHT);
    } 
    
    public void createFrame(String str, JLabel jb){
        JFrame jj = new JFrame(str);
        jj.add(jb);
        
        jj.setSize(300,150);
        jj.setLocationRelativeTo(null);
        jj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jj.setVisible(true);
        
    }
    
    public static void main(String[] args){
        new p3q1();
    }
    
}
