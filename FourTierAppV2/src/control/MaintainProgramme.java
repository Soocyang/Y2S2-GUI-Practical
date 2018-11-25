package control;

import da.ProgrammeDA;
import domain.Programme;
import java.util.ArrayList;

public class MaintainProgramme {

    private ProgrammeDA progDA;

    public MaintainProgramme() {
        progDA = new ProgrammeDA();
    }
    
    public Programme selectRecord(String code) {
        return progDA.getRecord(code);
    }
    
    public ArrayList<Programme> getAll() {
        return progDA.getProgrammes();
    }

}
