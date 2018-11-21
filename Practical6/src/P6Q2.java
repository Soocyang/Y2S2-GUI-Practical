
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class P6Q2 extends JFrame {

    //Component for Panel North
    private JTextField jtfName = new JTextField();
    private JTextField jtfID = new JTextField();

    //Component for Panel West
    private String[] programme = {"DIA 2", "DIB 2", "DIT 2", "DST 2"};
    private JComboBox jcbProgm = new JComboBox(programme);
    private String selectedProgm = "";

    //Component for Panel East
    private JCheckBox jcbWIN8 = new JCheckBox("Windows 8");
    private JCheckBox jcbWIN10 = new JCheckBox("Windows 10");
    private JCheckBox jcbVS15 = new JCheckBox("Visual Studio 2015");
    private JCheckBox jcbSQL = new JCheckBox("SQL Server");

    //Component
    private JButton jbtConfirm = new JButton("Confirm");
    private JButton jbtClear = new JButton("Clear");
    private JButton jbtExit = new JButton("Exit");

    public P6Q2() {

        //Panel North
        JPanel paneNorth = new JPanel(new GridLayout(2, 2));
        paneNorth.add(new JLabel("Name"));
        paneNorth.add(jtfName);
        paneNorth.add(new JLabel("ID"));
        paneNorth.add(jtfID);
        add(paneNorth, BorderLayout.NORTH);

        //Panel West
        JPanel paneWest = new JPanel(new GridLayout(5, 1));
        jcbProgm.setSelectedItem(null);
        paneWest.add(new JLabel("Programme"));
        paneWest.add(jcbProgm);
        add(paneWest);

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

        //ComboBox ItemListener
        jcbProgm.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                selectedProgm = getProgramme(jcbProgm.getSelectedIndex());
            }
        });

        //Button Listener
        jbtConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int confirm = JOptionPane.showConfirmDialog(null, getInfo(selectedProgm, getSoftware()), "Check Information", JOptionPane.YES_NO_OPTION);

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
                jcbProgm.setSelectedItem(null);  
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

    private String getProgramme(int index) {
        String progm;

        progm = programme[index];

        return progm;
    }

    private String getSoftware() {
        String software = "";
        if (jcbWIN8.isSelected()) {
            software += "-Windows 8\n";
        }
        if (jcbWIN10.isSelected()) {
            software += "-Windows 10\n";
        }
        if (jcbVS15.isSelected()) {
            software += "-Visual Studio 2015\n";
        }
        if (jcbSQL.isSelected()) {
            software += "-SQL Server\n";
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
        P6Q2 test = new P6Q2();
        test.setTitle("CheckOutSystem");
        test.pack();
        //test.setSize(500,500);
        test.setLocationRelativeTo(null);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setVisible(true);

    }

}
