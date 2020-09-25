package by.toxa.controllers;

import by.toxa.model.User;
import by.toxa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ModelAndView Home(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }
    @GetMapping("/users")
    public ModelAndView allUsers(){
        List<User> users= userService.allUsers();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("userList",users);
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView editPage(@PathVariable("id") int id){
        User user= userService.getById(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("user",user);
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView editUser (@ModelAttribute("user") User user){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("redirect:/users");
        userService.edit(user);
        return  modelAndView;
    }


    @GetMapping ("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id")int id){
        ModelAndView modelAndView  = new ModelAndView();
        modelAndView.setViewName("redirect:/users");
        User user=userService.getById(id);
        userService.delete(user);
        return modelAndView;
    }


}
