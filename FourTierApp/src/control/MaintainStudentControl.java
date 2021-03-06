/* 
*Student Name   : Soo Cia Yang
*Student ID     : 17WMD05652
*Tutotial Group : GP1
*Practical 5 Question 3
*--------------------------------------
*/

package control;

import da.StudentDA;
import domain.Student;

public class MaintainStudentControl {

    private StudentDA studDA = new StudentDA();

    public Student selectRecord(String id) {
        return studDA.getRecord(id);

    }

    public void addRecord(Student student) {
        studDA.addRecord(student);

    }

    public void updateRecord(Student student) {
        studDA.updateRecord(student);

    }
    
    public void deleteRecord(Student student) {
        studDA.deleteRecord(student);
    }

}
