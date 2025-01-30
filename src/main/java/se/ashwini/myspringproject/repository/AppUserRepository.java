package se.ashwini.myspringproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.ashwini.myspringproject.model.ApplicationUser;

public interface AppUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);

}

/**
 * AppUserRepository is responsible for communicating with the database to handle user-related operations.
 * JpaRepository is part of Spring Data JPA and provides built-in methods to interact with the database,for operations.
 * ApplicationUser is the entity.
 * Long is the type of the primary key (ID) for that entity.
 * ApplicationUser findByUsername(String username);
 * This defines a custom query method to find a user by their username.
 * Spring Data automatically interprets this method based on its name and generates the appropriate SQL query.
 */


