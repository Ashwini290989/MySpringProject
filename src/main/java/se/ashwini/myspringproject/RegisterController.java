package se.ashwini.myspringproject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.ashwini.myspringproject.model.ApplicationUser;
import se.ashwini.myspringproject.repository.AppUserRepository;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private AppUserRepository appUserRepository;
    private PasswordEncoder passwordEncoder;

    public RegisterController(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public String register(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("role") String role) {

        // saving new user

        String encodedPassword = passwordEncoder.encode(password);
        ApplicationUser applicationUser = new ApplicationUser(username,encodedPassword,role);
        appUserRepository.save(applicationUser);
        return "registerDone";


    }
}





