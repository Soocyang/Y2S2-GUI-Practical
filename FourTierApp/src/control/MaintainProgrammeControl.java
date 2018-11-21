/* 
*Student Name   : Soo Cia Yang
*Student ID     : 17WMD05652
*Tutotial Group : GP1
*Practical 5 Question 3
*--------------------------------------
*/

package control;

import da.ProgrammeDA;
import domain.Programme;

public class MaintainProgrammeControl {

    private ProgrammeDA progDA;

    public MaintainProgrammeControl() {
        progDA = new ProgrammeDA();
    }

    public Programme selectRecord(String code) {
        return progDA.getRecord(code);
    }
    
    public void addRecord(Programme progm){
        progDA.addRecord(progm);
    }

    public void updateRecord(Programme progm) {
        progDA.updateRecord(progm);

    }

    public void deleteRecord(Programme progm) {
        progDA.deleteRecord(progm);
    }

    

}
