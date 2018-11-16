/* 
@Student Name   : Soo Cia Yang
@Student ID     : 17WMD05652
@Tutotial Group : GP1
@Practical 3 Question 1
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class P3Q1 extends JFrame {

    ImageIcon grapeIcon = new ImageIcon(getClass().getResource("/images/grapes.gif"));
    private final JButton btnGrapes = new JButton("Grapes", grapeIcon);

    //Icon Alignment Button
    private final JRadioButton hLeft = new JRadioButton("Left/Leading");
    private final JRadioButton hCenter = new JRadioButton("Center");
    private final JRadioButton hRight = new JRadioButton("Right");

    private final JRadioButton vTop = new JRadioButton("Top");
    private final JRadioButton vCenter = new JRadioButton("Center");
    private final JRadioButton vBottom = new JRadioButton("Bottom");

    //Text Alignment Button
    private final JRadioButton txtHLeft = new JRadioButton("Left/Leading");
    private final JRadioButton txtHCenter = new JRadioButton("Center");
    private final JRadioButton txtHRight = new JRadioButton("Right");

    private final JRadioButton txtVTop = new JRadioButton("Top");
    private final JRadioButton txtVCenter = new JRadioButton("Center");
    private final JRadioButton txtVBottom = new JRadioButton("Bottom");

    public P3Q1() {

        //Create Button
        JPanel p2 = new JPanel();
        JPanel radioPanelH = new JPanel();
        JPanel radioPanelV = new JPanel();
        JPanel radioPaneTextAlignmentH = new JPanel();
        JPanel radioPaneTextAlignmentV = new JPanel();
        ButtonGroup groupBtn = new ButtonGroup();
        ButtonGroup groupBtn2 = new ButtonGroup();

        //Radio Button Grouping
        groupBtn.add(hLeft);
        groupBtn.add(hCenter);
        groupBtn.add(hRight);
        groupBtn.add(vTop);
        groupBtn.add(vCenter);
        groupBtn.add(vBottom);

        //Grouping 2
        groupBtn2.add(txtHLeft);
        groupBtn2.add(txtHCenter);
        groupBtn2.add(txtHRight);
        groupBtn2.add(txtVTop);
        groupBtn2.add(txtVCenter);
        groupBtn2.add(txtVBottom);

        //Add ActionListener
        radioBtnListener actionListener = new radioBtnListener();
        hLeft.addActionListener(actionListener);
        hCenter.addActionListener(actionListener);
        hRight.addActionListener(actionListener);
        vTop.addActionListener(actionListener);
        vCenter.addActionListener(actionListener);
        vBottom.addActionListener(actionListener);
        //---
        txtHLeft.addActionListener(actionListener);
        txtHCenter.addActionListener(actionListener);
        txtHRight.addActionListener(actionListener);
        txtVTop.addActionListener(actionListener);
        txtVCenter.addActionListener(actionListener);
        txtVBottom.addActionListener(actionListener);
        
        
        //Add Radio Buttonss
        radioPanelH.add(hLeft);
        radioPanelH.add(hCenter);
        radioPanelH.add(hRight);
        radioPanelH.setLayout(new GridLayout(3, 2));
        radioPanelH.setBorder(new TitledBorder("Set Horizontal"));
        radioPanelV.add(vTop);
        radioPanelV.add(vCenter);
        radioPanelV.add(vBottom);
        radioPanelV.setLayout(new GridLayout(3, 2));
        radioPanelV.setBorder(new TitledBorder("Set Vertical"));
        //-----
        radioPaneTextAlignmentH.add(txtHLeft);
        radioPaneTextAlignmentH.add(txtHCenter);
        radioPaneTextAlignmentH.add(txtHRight);
        radioPaneTextAlignmentH.setLayout(new GridLayout(3, 2));
        radioPaneTextAlignmentH.setBorder(new TitledBorder("Set Text Horizontal"));
        radioPaneTextAlignmentV.add(txtVTop);
        radioPaneTextAlignmentV.add(txtVCenter);
        radioPaneTextAlignmentV.add(txtVBottom);
        radioPaneTextAlignmentV.setLayout(new GridLayout(3, 2));
        radioPaneTextAlignmentV.setBorder(new TitledBorder("Set Text Vertical"));

        p2.add(radioPanelH);
        p2.add(radioPanelV);
        p2.add(radioPaneTextAlignmentH);
        p2.add(radioPaneTextAlignmentV);
        p2.setLayout(new GridLayout(2, 1));

        add(btnGrapes, BorderLayout.CENTER);
        add(p2, BorderLayout.EAST);


        //Frame Component
        setTitle("Button Icons");
        setSize(600, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //pack();
        setVisible(true);
    }

    public static void main(String[] args) {                    //Main IS HERE ~
        new P3Q1();
    }

    private class radioBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JRadioButton button = (JRadioButton) e.getSource();

            if (button == hLeft) {
                btnGrapes.setHorizontalAlignment(SwingConstants.LEFT);
            } else if (button == hCenter) {
                btnGrapes.setHorizontalAlignment(SwingConstants.CENTER);
            } else if (button == hRight) {
                btnGrapes.setHorizontalAlignment(SwingConstants.RIGHT);
            } else if (button == vTop) {
                btnGrapes.setVerticalAlignment(SwingConstants.TOP);
            } else if (button == vCenter) {
                btnGrapes.setVerticalAlignment(SwingConstants.CENTER);
            } else if (button == vBottom) {
                btnGrapes.setVerticalAlignment(SwingConstants.BOTTOM);
            } else if (button == txtHLeft){
                btnGrapes.setHorizontalTextPosition(SwingConstants.LEFT);
            } else if ( button == txtHCenter){
                btnGrapes.setHorizontalTextPosition(SwingConstants.CENTER);
            } else if ( button == txtHRight){
                btnGrapes.setHorizontalTextPosition(SwingConstants.RIGHT);
            } else if (button == txtVTop){
                btnGrapes.setVerticalTextPosition(SwingConstants.TOP);
            } else if ( button == txtVCenter){
                btnGrapes.setVerticalTextPosition(SwingConstants.CENTER);
            } else if ( button == txtVBottom){
                btnGrapes.setVerticalTextPosition(SwingConstants.BOTTOM);
            }

        }

    }

}
