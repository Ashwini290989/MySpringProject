package se.ashwini.myspringproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;//Provides a way to pass data from the backend to the frontend (like a webpage).
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;//specifies a common base URL for multiple methods in the same controller.
import se.ashwini.myspringproject.model.ApplicationUser;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/register")// handle request
public class RegisterSuccess {
    @GetMapping// Maps the registerDone() method to handle GET requests for the /register path.
    public String registerDone(Model model) {
        ApplicationUser user = new ApplicationUser();
        model.addAttribute("user", user);

        List<String>list = Arrays.asList("User","Admin","Manager");
        model.addAttribute("list", list);
        return "register";

    }
    /**
     * create a new empty instance of application user.
     * adds the empty user object to the model.
     * create a list containing three strings.Add the list of roles to the model.
     * directs the user to the register HTML page.
     */


}
