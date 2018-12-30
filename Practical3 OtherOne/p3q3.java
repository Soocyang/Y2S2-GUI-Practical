/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practical3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class p3q3 extends JFrame{
    private JLabel name = new JLabel("Name");
    private JTextField jtfName = new JTextField(30);
    private JLabel password = new JLabel("Password");
    private JPasswordField jtfPassword =new JPasswordField(15);
    private JButton login = new JButton("Login");
    private JButton reset = new JButton("Reset");
    
    public p3q3(){
        JPanel cc = new JPanel(new GridLayout(3,2));
        JPanel ss = new JPanel();
        
        cc.add(name);
        cc.add(jtfName);
        cc.add(password);
        cc.add(jtfPassword);
        jtfPassword.setEchoChar('*');
        add(cc,BorderLayout.CENTER);
        ss.add(login);
        login.addActionListener(new ButtonListener());
        ss.add(reset);
        add(ss,BorderLayout.SOUTH);
      
        setTitle("Login");
        setSize(400,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    
    public class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==login){
                
             p3q2 qq = new p3q2();  
            }
            else{
            reset.setText("");
            }
        }
    }
    
    public static void main (String[] args){
        new p3q3();
    }
    
}
