package by.toxa.controllers;

import by.toxa.model.User;
import by.toxa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

    @Autowired
    UserService userService;

    @GetMapping("/add")
    public ModelAndView addPage(){

        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("mail");
        return modelAndView;

    }


    @GetMapping("/login")
    public ModelAndView login (){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @GetMapping("/login/{error}")
    public ModelAndView errorLogin (@PathVariable(name = "error")  Boolean error){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("error",Boolean.TRUE);
        return modelAndView;
    }


}
