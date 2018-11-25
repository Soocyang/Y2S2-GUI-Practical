/* 
*Student Name   : Soo Cia Yang
*Student ID     : 17WMD05652
*Tutotial Group : GP1
*Practical 6 Question 2
*--------------------------------------
*/

package ui;

import control.MaintainProgramme;
import domain.Programme;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 *
 *
 *
 */
public class ProgrammeFrame extends JFrame {

    private DefaultComboBoxModel cboxModel = new DefaultComboBoxModel();
    private JComboBox jcboxProgm = new JComboBox(cboxModel);
    private JTextField jtfProgmName = new JTextField();
    private JTextField jtfFaculty = new JTextField();
    private MaintainProgramme progmControl;
    private ArrayList<Programme> progmList;

    public ProgrammeFrame() {
       progmControl = new MaintainProgramme();
        intializeModel();
        add(jcboxProgm, BorderLayout.NORTH);
        jcboxProgm.addActionListener(new SelectProgmListener());
        
        JPanel paneCenter = new JPanel(new GridLayout(2,2));
        paneCenter.add(new JLabel("Programme Name"));
        paneCenter.add(jtfProgmName);
        paneCenter.add(new JLabel("Faculty"));
        paneCenter.add(jtfFaculty);
        add(paneCenter);
        jtfProgmName.setHorizontalAlignment(SwingConstants.LEFT);
        setTextFields(progmList.get(0));
        
        
        
    }

    private void intializeModel() {
        progmList = progmControl.getAll();
        for (int i = 0; i < progmList.size(); i++) {
            cboxModel.addElement(progmList.get(i).getCode());
        }
    }

    private class SelectProgmListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Programme programme = progmList.get(jcboxProgm.getSelectedIndex());
            setTextFields(programme);
        }

    }
    
    private void setTextFields(Programme progm){
        jtfProgmName.setText(progm.getName());
        jtfFaculty.setText(progm.getFaculty());
    }

    public static void main(String[] args) {
        ProgrammeFrame frame = new ProgrammeFrame();
        frame.setTitle("Select Programme");
        frame.setSize(600,150);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
