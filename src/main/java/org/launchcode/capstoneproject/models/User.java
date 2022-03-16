package org.launchcode.capstoneproject.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User extends AbstractEntity{

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @NotNull(message = "Nope, you can't leave your name blank.")
    private String username;

    @Email(message = "Yep, you have to enter your email.")
    private String email;

    @NotNull(message = "Hey, you need a password to protect your personal stuff.")
    @Size(min = 8, message = "Don't get slack, you need at least 8 characters here.")
    private String pwHash;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.pwHash = encoder.encode(password);
    }

    public User() {}

    public String getUsername() {
        return username;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }
}
