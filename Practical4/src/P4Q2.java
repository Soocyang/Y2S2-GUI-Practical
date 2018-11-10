/* 
@Student Name   : Soo Cia Yang
@Student ID     : 17WMD05652
@Tutotial Group : GP1
@Practical 4 Question 2
--------------------------------------
 */
import java.util.*;
import java.math.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class P4Q2 extends JFrame {

    private static final int[] numArray = new int[100];
    private static final Random rand = new Random();
    private static final JTextField arrIndex = new JTextField();
    private static final JTextField arrElem = new JTextField();
    private static final JButton show = new JButton("Show Element");

    public P4Q2() {

        //Generating Random numbers for Array
        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = rand.nextInt(1000) + 1;
            System.out.println((i + 1) + "   " + numArray[i]);
        }

        //Add Component
        JPanel pane1 = new JPanel();
        pane1.setLayout(new GridLayout(2, 2));
        pane1.add(new JLabel("Array Index"));
        pane1.add(arrIndex);
        pane1.add(new JLabel("Array Element"));
        pane1.add(arrElem);
        arrElem.setEditable(false);
        
        
        show.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int getIndex = Integer.parseInt(arrIndex.getText());
                
                try{
                arrElem.setText(String.format("%d", numArray[getIndex-1]));
                }catch(ArrayIndexOutOfBoundsException ex){
                    
                    arrElem.setText("Out of Bound");
                    
                }
            }
        });
        
        add(pane1, BorderLayout.CENTER);
        add(show, BorderLayout.SOUTH);

        //Frame Component
        setTitle("Display:Show Bonds Error");
        setSize(350, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pack();

        setVisible(true);

    }

    public static void main(String[] args) {

        new P4Q2();

    }

}
