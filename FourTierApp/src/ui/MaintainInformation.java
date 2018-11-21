/* 
*Student Name   : Soo Cia Yang
*Student ID     : 17WMD05652
*Tutotial Group : GP1
*Practical 5 Question 3
*--------------------------------------
*/

package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MaintainInformation extends JFrame {

    private JButton jbtMaintainProgm = new JButton("Maintain Programme");
    private JButton jbtMaintainStud = new JButton("Maintain Student");

    public MaintainInformation() {

        setLayout(new GridLayout(2,1));
        add(jbtMaintainProgm, BorderLayout.NORTH);
        add(jbtMaintainStud, BorderLayout.CENTER);

        jbtMaintainProgm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MaintainProgrammeFrame frm = new MaintainProgrammeFrame();
                frm.setTitle("Programme CRUD");
                frm.setSize(600, 300);
                frm.setLocationRelativeTo(null);
                frm.setVisible(true);
            }
        });

        jbtMaintainStud.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MaintainStudentFrame frm = new MaintainStudentFrame();
                frm.setTitle("Student CRUD");
                frm.setSize(600, 500);
                frm.setLocationRelativeTo(null);
                frm.setVisible(true);

            }
        });
}

    public static void main(String[] args) {
        MaintainInformation homeFrame = new MaintainInformation();
        homeFrame.setTitle("Maintain Information");
        homeFrame.setSize(400,300);
        homeFrame.setLocationRelativeTo(null);
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeFrame.setVisible(true);

    }
}
