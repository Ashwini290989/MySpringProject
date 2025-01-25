package se.ashwini.myspringproject;

import jakarta.annotation.PostConstruct;
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
            ApplicationUser user = new ApplicationUser();
            user.setUsername("ashwini");
            user.setPassword(passwordEncoder.encode("password"));
            user.setRole("ADMIN");
            appUserRepository.save(user);
        }

        if (appUserRepository.findByUsername("rakesh") == null) {
            ApplicationUser user1 = new ApplicationUser();
            user1.setUsername("rakesh");
            user1.setPassword(passwordEncoder.encode("password1"));
            user1.setRole("USER");
            appUserRepository.save(user1);
        }

        if (appUserRepository.findByUsername("dhairya") == null) {
            ApplicationUser user2 = new ApplicationUser();
            user2.setUsername("dhairya");
            user2.setPassword(passwordEncoder.encode("password2"));
            user2.setRole("MANAGER");
            appUserRepository.save(user2);


        }
    }
}
