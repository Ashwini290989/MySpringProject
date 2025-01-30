package se.ashwini.myspringproject;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;//It provides methods to encrypt (hash) and verify passwords securely.
import org.springframework.stereotype.Component; // Spring handle creation and injection of this object.
import se.ashwini.myspringproject.model.ApplicationUser; // table class
import se.ashwini.myspringproject.repository.AppUserRepository; // repository

@Component
public class DataInitializer {
    private final AppUserRepository appUserRepository ; // Dependency injection with constructors
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

        /**
         * Checking for user if its already exit in database, if the user doesnot exit,it returns null.
         * creating a instance of appliacation user class, to create a new user you want to add.
         * setting new user, name, passowrd & role.
         * saving  new user to our repository.
         */



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
