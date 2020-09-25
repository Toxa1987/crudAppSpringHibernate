package by.toxa.controllers;

import by.toxa.model.User;
import by.toxa.service.MailSenderService;
import by.toxa.service.UserService;
import by.toxa.util.ValidateEmail;
import by.toxa.util.ValidatePassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MailController {
    @Autowired
   private MailSenderService mailSender;
    @Autowired
    private UserService userService;
    @Autowired
    private ValidateEmail validateEmail;

    @PostMapping("/send")
    public ModelAndView send(
            @ModelAttribute("user")User user,
            HttpServletRequest httpServletRequest){

        ModelAndView modelAndView=new ModelAndView();
        String email= httpServletRequest.getParameter("email");
        if (validateEmail.validateEmail(email)){
        userService.add(user);
        String massage="Your link for activation: http://localhost:8080/crudAppSpringHibernate/activation"+
                "/"+userService.getByName(email).getId();
        mailSender.send(email,"Your link for activation : ",massage);
        modelAndView.setViewName("home");
        }
        else{
            String error="This email is busy";
            modelAndView.setViewName("mail");
            modelAndView.addObject("error",error);
        }
        return modelAndView;
    }
    @GetMapping("/activation/{id}")
    public ModelAndView getActivation(@PathVariable("id") int id){

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("activation");
        modelAndView.addObject("user",userService.getById(id));

        return modelAndView;
    }
    @PostMapping("/activation")
    public ModelAndView activation(@ModelAttribute("user")User user,  HttpServletRequest request){

        ModelAndView modelAndView=new ModelAndView();
        int id=Integer.parseInt(request.getParameter("id"));
        String email= request.getParameter("email");
        String password1=request.getParameter("password1");
        String password2=request.getParameter("password2");
        if (ValidatePassword.validatePassword(password1,password2)) {
            user.setEmail(email);
            user.setPassword(password1);
            user.setActivated(true);
            userService.edit(user);
            modelAndView.setViewName("redirect:/");
        }
        else{
            modelAndView.setViewName("activation");
            modelAndView.addObject("id",id);
            modelAndView.addObject("error","Password mismatch");
        }
        return modelAndView;
    }
}
