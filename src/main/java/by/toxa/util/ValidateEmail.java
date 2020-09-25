package by.toxa.util;

import by.toxa.model.User;
import by.toxa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateEmail {

    @Autowired
   private  UserService userService;

    public  boolean validateEmail(String email){
        User user = userService.getByName(email);
        if (user==null)
            return true;
        else
            return false;
    }
}
