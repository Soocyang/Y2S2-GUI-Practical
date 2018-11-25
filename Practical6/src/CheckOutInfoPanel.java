/* 
*Student Name   : Soo Cia Yang
*Student ID     : 17WMD05652
*Tutotial Group : GP1
*Practical 6 Question 4
*--------------------------------------
*/

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CheckOutInfoPanel extends JPanel {

        public CheckOutInfoPanel(SoftwareCheckOut s) {

            setLayout(new GridLayout(10, 1));
            add(new JLabel("Software Checkout Summary"));
            add(new JLabel("Student name: " + s.getName()));
            add(new JLabel("Student id  : " + s.getId()));
            add(new JLabel("Programme   : " + s.getProgramme()));
            ArrayList<String> softwareList = s.getSoftwareList();
            for (int i = 0; i < softwareList.size(); i++) {
                add(new JLabel("- " + (i + 1) + ". " + softwareList.get(i)));
            }
        }
    }