package se.ashwini.myspringproject.model;

import jakarta.persistence.Column; // To Specify column in the database
import jakarta.persistence.Entity; // represents table in the database
import jakarta.persistence.GeneratedValue;// Tells the database to automatically generate value.
import jakarta.persistence.Id;//This marks a specific field (like id) as the unique identifier for each row in the database.

@Entity
public class ApplicationUser {
    @Id
    @GeneratedValue
    private int id;
@Column(nullable = false,unique = true)// username column cannot be empty.Each value in the username column must be different.
    private String username;
@Column(nullable = false)
    private String password;
    private String role;

    public ApplicationUser() {// when reading from a database, spring might need to instantiate  class without any arguments.

    }

    public ApplicationUser(String username,  String role, String password) {
        this.username = username;
        this.role = role;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
/** constructors to create and initialize objects.
 * getter methods to get values.
 * setter methods to set new values.
 */
