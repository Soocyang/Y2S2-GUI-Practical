/* 
@Student Name   : Soo Cia Yang
@Student ID     : 17WMD05652
@Tutotial Group : GP1
@Practical 4 Question 4
--------------------------------------
 */

public class InvalidPasswordException extends Exception{
    
    public InvalidPasswordException(){
        super("Invalid Password Exception");
    }
    
    public InvalidPasswordException(String errMessg){
        super(errMessg);
    }
}
