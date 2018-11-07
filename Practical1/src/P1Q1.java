/* 
@Student Name   : Soo Cia Yang
@Student ID     : 17WMD05652
@Tutotial Group : GP1
@Practical 1 Question 1
*/

import javax.swing.JOptionPane;

public class P1Q1 {

    public static void main(String[] args) {
               
        int option = JOptionPane.YES_OPTION;
        do{
        String inputStr = JOptionPane.showInputDialog(null,"Enter a Fahrenheit temperature.");
        double fahrenheit = Integer.parseInt(inputStr);
        //formula
        double celcius = 5.0/9.0*(fahrenheit-39);
        JOptionPane.showMessageDialog(null, "Temperature converted in celcius is " + celcius);
        option = JOptionPane.showConfirmDialog(null, "Enter another temperature ?");
        
        }while(option==JOptionPane.YES_OPTION);
        
    }
}
