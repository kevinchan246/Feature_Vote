package com.featurevote.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    //@RequestMapping(value="/login", method=RequestMethod.GET)
    @GetMapping("/login")  //exactly same as above line
    public  String login(){
        return "login";
    }
}
