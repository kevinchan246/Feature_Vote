package com.featurevote.web;

        import com.featurevote.domain.Product;
        import com.featurevote.domain.User;
        import com.featurevote.repositories.ProductRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.security.core.annotation.AuthenticationPrincipal;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.ModelMap;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;

        import java.util.List;


@Controller
public class DashboardController {
    //@RequestMapping(value = "/", method = RequestMethod.GET)

    @Autowired
    private ProductRepository productRepo;

    @GetMapping("/")                //mapping to root page, same thing as the above line
    public String rootView(){
        return "index";             //returning the the page mapped, root page in this case
    }

    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal User user, ModelMap model){
        List<Product> products = productRepo.findByUser(user);

        model.put("products", products);

        return "dashboard";
    }


}
