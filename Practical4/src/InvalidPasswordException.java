
public class InvalidPasswordException extends Exception{
    
    public InvalidPasswordException(){
        super("Invalid Password Exception");
    }
    
    public InvalidPasswordException(String errMessg){
        super(errMessg);
    }
}
