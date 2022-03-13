package org.launchcode.capstoneproject.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {

    private int id;

    @NotBlank(message = "Nope, you can't leave your name blank.")
    private String name;

    @Email(message = "Yep, you have to enter your email.")
    private String email;

    @NotBlank(message = "Hey, you need a password to protect your personal stuff.")
    @Size(min = 8, message = "Don't get slack, you need at least 8 characters here.")
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User() {}
}
