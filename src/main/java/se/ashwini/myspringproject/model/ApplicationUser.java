package se.ashwini.myspringproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.context.annotation.Role;
@Entity
public class ApplicationUser {
@Column(nullable = false,unique = true)
    private String username;
    private String password;
    private String role;

    @Id
    @GeneratedValue
    private int id;
    public ApplicationUser(String username, int id, String role, String password) {
        this.username = username;
        this.id = id;
        this.role = role;
        this.password = password;
    }

    public ApplicationUser() {
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
