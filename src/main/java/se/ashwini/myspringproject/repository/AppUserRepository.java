package se.ashwini.myspringproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.ashwini.myspringproject.model.ApplicationUser;

public interface AppUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);

}


