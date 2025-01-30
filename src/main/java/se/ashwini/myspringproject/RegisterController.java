package se.ashwini.myspringproject;

import org.springframework.security.crypto.password.PasswordEncoder;//helps to encrypt password.
import org.springframework.stereotype.Controller;// marks the class as controller in spring MVC application.
import org.springframework.web.bind.annotation.PostMapping;// allow us to map POST request. used to submit form.
import org.springframework.web.bind.annotation.RequestMapping; // allow us to map specif url.
import org.springframework.web.bind.annotation.RequestParam; // to find specific path.
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
        ApplicationUser applicationUser = new ApplicationUser(username,role,encodedPassword);
        appUserRepository.save(applicationUser);
        return "register_done";


    }
    /**
     * POSTMapping handles http Post request.
     * captures the username,password,role.
     * Encrypts the password using passwordEncoder.
     * create a new user with name, role , password.
     * saving new user in our database.
     */
}





