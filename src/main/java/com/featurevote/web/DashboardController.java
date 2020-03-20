package com.featurevote.web;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DashboardController {
    //@RequestMapping(value = "/", method = RequestMethod.GET)


    @GetMapping("/")                //mapping to root page, same thing as the above line
    public String rootView(){
        return "index";             //returning the the page mapped, root page in this case
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }
}
