/* 
*Student Name   : Soo Cia Yang
*Student ID     : 17WMD05652
*Tutotial Group : GP1
*Practical 6 Question 4
*--------------------------------------
*/
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class P6Q4 extends JFrame {

    //Component for Panel North
    private JTextField jtfName = new JTextField();
    private JTextField jtfID = new JTextField();

    //Component for Panel West
    private JRadioButton jrbDIA2 = new JRadioButton("DIA2");
    private JRadioButton jrbDIB2 = new JRadioButton("DIB2");
    private JRadioButton jrbDIT2 = new JRadioButton("DIT2");
    private JRadioButton jrbDST2 = new JRadioButton("DST2");

    //Component for Panel East
    private JCheckBox jcbWIN8 = new JCheckBox("Windows 8");
    private JCheckBox jcbWIN10 = new JCheckBox("Windows 10");
    private JCheckBox jcbVS15 = new JCheckBox("Visual Studio 2015");
    private JCheckBox jcbSQL = new JCheckBox("SQL Server");

    //Component
    private JButton jbtConfirm = new JButton("Confirm");
    private JButton jbtClear = new JButton("Clear");
    private JButton jbtExit = new JButton("Exit");

    public P6Q4() {

        //Panel North
        JPanel paneNorth = new JPanel(new GridLayout(2, 2));
        paneNorth.add(new JLabel("Name"));
        paneNorth.add(jtfName);
        paneNorth.add(new JLabel("ID"));
        paneNorth.add(jtfID);
        add(paneNorth, BorderLayout.NORTH);

        //Panel West
        JPanel paneWest = new JPanel(new GridLayout(5, 1));
        paneWest.add(new JLabel("Programme"));
        paneWest.add(jrbDIA2);
        paneWest.add(jrbDIB2);
        paneWest.add(jrbDIT2);
        paneWest.add(jrbDST2);
        //Group Button
        ButtonGroup btg = new ButtonGroup();
        btg.add(jrbDIA2);
        btg.add(jrbDIB2);
        btg.add(jrbDIT2);
        btg.add(jrbDST2);
        add(paneWest, BorderLayout.WEST);

        //Panel East
        JPanel paneEast = new JPanel(new GridLayout(5, 1));
        paneEast.add(new JLabel("Software"));
        paneEast.add(jcbWIN8);
        paneEast.add(jcbWIN10);
        paneEast.add(jcbVS15);
        paneEast.add(jcbSQL);
        add(paneEast, BorderLayout.EAST);

        //Panel South
        JPanel paneSouth = new JPanel(new FlowLayout(FlowLayout.CENTER));
        paneSouth.add(jbtConfirm);
        paneSouth.add(jbtClear);
        paneSouth.add(jbtExit);
        add(paneSouth, BorderLayout.SOUTH);

        //Button Listener
        jbtConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = jtfName.getText();
                String id = jtfID.getText();
                String progm = getProgramme();
                ArrayList<String> software = getSoftware();

                SoftwareCheckOut sco = new SoftwareCheckOut(name, id, progm, software);

                JFrame frame = new JFrame();
                frame.setTitle("CheckOutPanel");
                frame.add(new CheckOutInfoPanel(sco));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

            }
        });

        jbtClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtfName.setText("");
                jtfID.setText("");
                btg.clearSelection();
                jcbWIN8.setSelected(false);
                jcbWIN10.setSelected(false);
                jcbVS15.setSelected(false);
                jcbSQL.setSelected(false);
                jtfName.requestFocusInWindow();
            }
        });

        jbtExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    private String getProgramme() {
        String progm = "";
        if (jrbDIA2.isSelected()) {
            progm = "DIA2";
        } else if (jrbDIB2.isSelected()) {
            progm = "DIB2";
        } else if (jrbDIT2.isSelected()) {
            progm = "DIT2";
        } else if (jrbDST2.isSelected()) {
            progm = "DST2";
        }
        return progm;
    }

    private ArrayList<String> getSoftware() {
        ArrayList<String> software = new ArrayList<String>();
        if (jcbWIN8.isSelected()) {
            software.add("-Windows 8\n");
        }
        if (jcbWIN10.isSelected()) {
            software.add("Windows 10\n");
        }
        if (jcbVS15.isSelected()) {
            software.add("Visual Studio 2015\n");
        }
        if (jcbSQL.isSelected()) {
            software.add("SQL Server\n");
        }
        return software;
    }

    public static void main(String[] args) {
        P6Q4 test = new P6Q4();
        test.setTitle("CheckOutSystem");
        test.pack();
        //test.setSize(500,500);
        test.setLocationRelativeTo(null);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setVisible(true);

    }

    
}
