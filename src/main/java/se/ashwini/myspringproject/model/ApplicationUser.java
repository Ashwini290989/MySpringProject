package se.ashwini.myspringproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ApplicationUser {
    @Id
    @GeneratedValue
    private int id;
@Column(nullable = false,unique = true)
    private String username;
    private String password;
    private String role;

    public ApplicationUser() {

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
