
import java.util.*;
import java.lang.*;

public class Password {

    private char[] password;

    public Password() {

    }

    public Password(char[] password) throws InvalidPasswordException{

        StringBuilder errMessage = new StringBuilder();

        this.password = password;

        int i = 0;      //Counter for isDigit;
        int j = 0;      //Counter for isAlphabetic;
        for (char c : password) {
            if (Character.isDigit(c)) {
                i++;
            }
            if (Character.isAlphabetic(c)) {
                j++;
            }
        }

        //if password is null
        if (password.length == 0) {
            errMessage.append("Invalid Password: password cannot be null or an empty string.\n");
        }else{
        
        //Password less than 7 characters
        if (((i + j) < 7)) {
            errMessage.append("Your password should have at least 7 alpha-numeric characters.\n");
        }

        //if password contains all digits
        if (i == password.length) {
            errMessage.append("Your password should have at least 1 character.\n");
        }

        //if password contains all characters
        if (j == password.length) {
            errMessage.append("Your password should have at least 1 digit.\n");
        }
        }
        

        
        
        throw new InvalidPasswordException(errMessage.toString());
        

    }

}
