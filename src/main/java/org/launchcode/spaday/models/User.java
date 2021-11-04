package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    @NotEmpty(message = "Please enter a username")
    @Size(min=5, max=15, message="Username must be between 5 and 15 chars.")
    private String username;

    @Email(message = "Please enter a valid email address")
    private String email;

    @NotEmpty(message="Please enter a password.")
    @Size(min=6, message="password must be at least 6 chars.")
    private String password;

    //Bonus
    @NotNull(message = "Passwords do not match")
    private String verifyPassword;

    public User() {
    }

    public User(String username, String email, String password, String verifyPassword) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifyPassword = verifyPassword;
    }

    private void checkPassword(){
        if (!password.equals(verifyPassword)){
            verifyPassword = null;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }
}
