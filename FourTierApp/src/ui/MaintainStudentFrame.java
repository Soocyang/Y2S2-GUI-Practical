/* 
*Student Name   : Soo Cia Yang
*Student ID     : 17WMD05652
*Tutotial Group : GP1
*Practical 5 Question 3
*--------------------------------------
*/

package ui;

import control.MaintainStudentControl;
import domain.Programme;
import domain.Student;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author User
 */
public class MaintainStudentFrame extends JFrame {

    private MaintainStudentControl studCtrl;
    private JTextField jtfStudID = new JTextField();
    private JTextField jtfStudIC = new JTextField();
    private JTextField jtfStudName = new JTextField();
    private JTextField jtfLevel = new JTextField();
    private JTextField jtfProgmCode = new JTextField();
    private JTextField jtfYear = new JTextField();
    private JButton jbtAdd = new JButton("Create");
    private JButton jbtRetrieve = new JButton("Retrieve");
    private JButton jbtUpdate = new JButton("Update");
    private JButton jbtDelete = new JButton("Delete");

    public MaintainStudentFrame() {

        studCtrl = new MaintainStudentControl();
        JPanel paneCenter = new JPanel(new GridLayout(6, 2));
        paneCenter.add(new JLabel("Student ID"));
        paneCenter.add(jtfStudID);
        paneCenter.add(new JLabel("Student IC"));
        paneCenter.add(jtfStudIC);
        paneCenter.add(new JLabel("Student Name"));
        paneCenter.add(jtfStudName);
        paneCenter.add(new JLabel("Level"));
        paneCenter.add(jtfLevel);
        paneCenter.add(new JLabel("Programme Code"));
        paneCenter.add(jtfProgmCode);
        paneCenter.add(new JLabel("Year"));
        paneCenter.add(jtfYear);
        add(paneCenter, BorderLayout.CENTER);

        JPanel paneSouth = new JPanel();
        paneSouth.add(jbtAdd);
        paneSouth.add(jbtRetrieve);
        paneSouth.add(jbtUpdate);
        paneSouth.add(jbtDelete);
        add(paneSouth, BorderLayout.SOUTH);

        //jbtAdd.addActionListener(new AddListener());
        jbtRetrieve.addActionListener(new RetrieveListener());
        jbtAdd.addActionListener(new AddListener());
        jbtUpdate.addActionListener(new UpdateListener());
        jbtDelete.addActionListener(new DeleteListener());

    }

    //ListenerSSSS
    private class RetrieveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String id = jtfStudID.getText();
            Student student = studCtrl.selectRecord(id);

            if (student != null) {
                jtfStudID.setText(student.getId());
                jtfStudIC.setText(student.getIc());
                jtfStudName.setText(student.getName());
                jtfLevel.setText(String.format("%c", student.getLevel()));
                jtfProgmCode.setText(student.getProgramme().getCode());
                jtfYear.setText(String.format("%d", student.getYear()));
            } else {
                JOptionPane.showMessageDialog(null, "No such student id.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
                clearTextField();
                jtfStudID.requestFocusInWindow();
            }
        }

    }

    private class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String id = jtfStudID.getText();
            String ic = jtfStudIC.getText();
            String name = jtfStudName.getText();
            char level = jtfLevel.getText().charAt(0);
            String progCode = jtfProgmCode.getText();
            int year = Integer.parseInt(jtfYear.getText());
            Student student = studCtrl.selectRecord(id);

            if (student != null) {
                JOptionPane.showMessageDialog(null, "Code already exist", "DUPLICATED CODE", JOptionPane.ERROR_MESSAGE);

                clearTextField();
                jtfStudID.requestFocusInWindow();
            } else {
                Programme progm = new Programme(progCode);
                student = new Student(id, ic, name, level, progm, year);
                studCtrl.addRecord(student);
            }
        }
    }

    private class UpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String id = jtfStudID.getText();
            String ic = jtfStudIC.getText();
            String name = jtfStudName.getText();
            char level = jtfLevel.getText().charAt(0);
            String progCode = jtfProgmCode.getText();
            int year = Integer.parseInt(jtfYear.getText());
            Student student = studCtrl.selectRecord(id);

            if (student == null) {
                JOptionPane.showMessageDialog(null, "No such student id.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
                clearTextField();
                jtfStudID.requestFocusInWindow();

            } else {
                Programme progm = new Programme(progCode);
                student = new Student(id, ic, name, level, progm, year);
                studCtrl.updateRecord(student);
            }
        }
    }

    private class DeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String id = jtfStudID.getText();
            Student student = studCtrl.selectRecord(id);

            if (student == null) {
                JOptionPane.showMessageDialog(null, "No such programme code.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
                clearTextField();
                jtfStudID.requestFocusInWindow();
            } else {
                int delRec = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record.");
                if (delRec == JOptionPane.YES_OPTION) {
                    studCtrl.deleteRecord(student);
                    clearTextField();
                    jtfStudID.requestFocusInWindow();
                }

            }

        }

    }

    public void clearTextField() {
        jtfStudID.setText("");
        jtfStudIC.setText("");
        jtfStudName.setText("");
        jtfLevel.setText("");
        jtfProgmCode.setText("");
        jtfYear.setText("");
    }

    public static void main(String[] args) {
        MaintainStudentFrame frm = new MaintainStudentFrame();
        frm.setTitle("Student CRUD");
        frm.setSize(600, 500);
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }

}
