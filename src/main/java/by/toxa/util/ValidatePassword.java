package by.toxa.util;

public class ValidatePassword {

    public  static Boolean validatePassword(String pas1,String pas2){
        if (pas1.equals(pas2))return true;
        else return false;
    }
}
