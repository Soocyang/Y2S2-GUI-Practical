/* 
*Student Name   : Soo Cia Yang
*Student ID     : 17WMD05652
*Tutotial Group : GP1
*Practical 6 Question 3
*--------------------------------------
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class P6Q3 extends JFrame {

    //Component for Panel North
    private JTextField jtfName = new JTextField();
    private JTextField jtfID = new JTextField();

    //Component for Panel West
    private JRadioButton jrbDIA2 = new JRadioButton("DIA2");
    private JRadioButton jrbDIB2 = new JRadioButton("DIB2");
    private JRadioButton jrbDIT2 = new JRadioButton("DIT2");
    private JRadioButton jrbDST2 = new JRadioButton("DST2");

    //Component for Panel East
    private String[] software = {"Windows 8", "Windows 10", "Visual Studio 2015", "SQL Server"};
    private JList jlsSoftware = new JList(software);

    //Component
    private JButton jbtConfirm = new JButton("Confirm");
    private JButton jbtClear = new JButton("Clear");
    private JButton jbtExit = new JButton("Exit");

    public P6Q3() {

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
        JPanel paneEast = new JPanel(new GridLayout(2, 1));
        paneEast.add(new JLabel("Software"));
        paneEast.add(jlsSoftware);
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

                int confirm = JOptionPane.showConfirmDialog(null, getInfo(getProgramme(), getSoftware()), "Check Information", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Thank you", "Message", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        jbtClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtfName.setText("");
                jtfID.setText("");
                btg.clearSelection();
                jlsSoftware.clearSelection();
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

    private String getSoftware() {
        String software = "";
        int[] indices = jlsSoftware.getSelectedIndices();

        int i;
        for (int x : indices) {
            software += "-" + this.software[x] + "\n";
        }

        return software;
    }

    private String getInfo(String programme, String software) {
        String name = jtfName.getText();
        String id = jtfID.getText();

        String msg = "Name: " + name + "\n"
                + "ID: " + id + "\n"
                + "Programme: " + programme + "\n"
                + "Software selected: \n" + software + "\n"
                + "Is the information correct?";
        return msg;
    }

    public static void main(String[] args) {
        P6Q3 test = new P6Q3();
        test.setTitle("CheckOutSystem");
        test.pack();
        //test.setSize(500,500);
        test.setLocationRelativeTo(null);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setVisible(true);

    }

}
