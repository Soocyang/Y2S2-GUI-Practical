/* 
@Student Name   : Soo Cia Yang
@Student ID     : 17WMD05652
@Tutotial Group : GP1
@Practical 2 Question 4
*/

import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class P2Q4 extends JFrame {

    private final JButton btnCreate = new JButton("Create");
    private final JButton btnRetrieve = new JButton("Retrieve");
    private final JButton btnUpdate = new JButton("Update");
    private final JButton btnDelete = new JButton("Delete");
    private ArrayList<String> studentList = new ArrayList<String>();
    private String studsName[] = {"Jack Ryan", "Anne Hathaway", "Marion Lee"};

    public P2Q4() {

        //Initialize name list
        for (int i = 0; i < studsName.length; i++) {
            studentList.add(studsName[i]);
        }

        //Creating Panel
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder("Please make your selection."));
        panel.add(btnCreate);
        panel.add(btnRetrieve);
        panel.add(btnUpdate);
        panel.add(btnDelete);

        add(panel);

        //Action Listener
        btnCreate.addActionListener(new createBtnListener());
        btnRetrieve.addActionListener(new retrieveBtnListener());
        btnUpdate.addActionListener(new updateBtnListener());
        btnDelete.addActionListener(new deleteBtnListener());

        //Frame Component
        setTitle("Maintain Students");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setSize(300,200);
        pack();
        setVisible(true);

    }

    public static void main(String[] args) {
        new P2Q4();
    }

    private class createBtnListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String stdName = JOptionPane.showInputDialog("Enter new student's name:");

            if (stdName != null) {
                studentList.add(stdName);
            }
            
            JOptionPane.showMessageDialog(null, retrieveStudList().toString(), "Updated Student List", JOptionPane.INFORMATION_MESSAGE);
            
        }

    }

    private class retrieveBtnListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String sequenceNo = JOptionPane.showInputDialog(null, "Enter sequence number [1.." + studentList.size() + "] to retrieve: ");
            int index = Integer.parseInt(sequenceNo) - 1;

            JOptionPane.showMessageDialog(null, studentList.get(index), "Retrieved Student Name", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    private class updateBtnListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String stdIndexinStr = JOptionPane.showInputDialog(null, retrieveStudList().toString() + "\nSelect student need to be updated :", "Updated Student List", JOptionPane.INFORMATION_MESSAGE);
            int studIndex = Integer.parseInt(stdIndexinStr) - 1;

            studentList.set(studIndex, (String) JOptionPane.showInputDialog(null, "Current student name is " + studentList.get(studIndex) + ". Enter updatedname:", "Update Student", JOptionPane.INFORMATION_MESSAGE, null, null, studentList.get(studIndex)));

            JOptionPane.showMessageDialog(null, retrieveStudList().toString(), "Updated Student List", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    private class deleteBtnListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String stdIndexinStr = JOptionPane.showInputDialog(null, retrieveStudList().toString() + "\nSelect student need to be delete :", "Updated Student List", JOptionPane.INFORMATION_MESSAGE);
            int studIndex = Integer.parseInt(stdIndexinStr) - 1;

            int option = JOptionPane.showConfirmDialog(null, "Delete " + studentList.get(studIndex) + " ?");

            if (option == JOptionPane.YES_OPTION) {
                
                JOptionPane.showMessageDialog(null, "Student " + studentList.get(studIndex) + " has been deleted.");
                studentList.remove(studIndex);
            }
            JOptionPane.showMessageDialog(null, retrieveStudList().toString(), "Updated Student List", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    //Use this method to get student list
    private StringBuilder retrieveStudList() {
        StringBuilder strBuild = new StringBuilder(studentList.size());
        for (int i = 0; i < studentList.size(); i++) {
            strBuild.append((i + 1) + ". " + studentList.get(i) + "\n");
        }

        return strBuild;
    }

}
