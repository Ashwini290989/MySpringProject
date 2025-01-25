package se.ashwini.myspringproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.ashwini.myspringproject.model.ApplicationUser;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/register")
public class MainController {
    @GetMapping
    public String registerDone(Model model) {
        ApplicationUser user = new ApplicationUser();
        model.addAttribute("user", user);

        List<String>list = Arrays.asList("User","Admin","Manager");
        model.addAttribute("list", list);
        return "register";

    }


}
