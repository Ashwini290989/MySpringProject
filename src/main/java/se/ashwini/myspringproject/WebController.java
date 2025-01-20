package se.ashwini.myspringproject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class WebController {
    @GetMapping("/")
    public String firstpage(Model model) {
        model.addAttribute("message", "You are logged in");
        return "login";
    }

    @GetMapping("/user")
    public String ShowMyUserName(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("username", username);
        return "user";


    }
    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("message", "ADMIN STUFF");
        return "admin";
    }

}
