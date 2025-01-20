package se.ashwini.myspringproject;

import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se.ashwini.myspringproject.model.ApplicationUser;
import se.ashwini.myspringproject.repository.AppUserRepository;

@Component
public class DataInitializer {

    private final AppUserRepository appUserRepository ;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void AddUsers() {
        if (appUserRepository.findByUsername("ashwini") == null) {
            ApplicationUser User = new ApplicationUser();
            User.setUsername("ashwini");
            User.setPassword(passwordEncoder.encode("password"));
            User.setRole("ADMIN");
            appUserRepository.save(User);
        }

        if (appUserRepository.findByUsername("rakesh") == null) {
            ApplicationUser User1 = new ApplicationUser();
            User1.setUsername("rakesh");
            User1.setPassword(passwordEncoder.encode("password1"));
            User1.setRole("USER");
            appUserRepository.save(User1);
        }

        if (appUserRepository.findByUsername("dhairya") == null) {
            ApplicationUser User2 = new ApplicationUser();
            User2.setUsername("dhairya");
            User2.setPassword(passwordEncoder.encode("password2"));
            User2.setRole("MANAGER");
            appUserRepository.save(User2);


        }
    }
}
