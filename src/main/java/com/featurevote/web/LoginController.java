package com.featurevote.web;

import com.featurevote.domain.User;
import com.featurevote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.management.modelmbean.ModelMBean;

//this is a spring controller, to tell spring to get and post the html pages, also includes data binding
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    //@RequestMapping(value="/login", method=RequestMethod.GET)
    @GetMapping("/login")  //exactly same as above line
    public  String login(){
        return "login";
    }

    @GetMapping("/register")
    public  String register(ModelMap model){
        model.put("user", new User()); //new blank user object ready for the registration
        return "register";
    }

    //when have postMapping, you are passing data into this method, and it should return a redirect page
    @PostMapping("/register")
    public  String registerPost(User user){
        User savedUser = userService.save(user);
        return "redirect:/login";
    }
}
