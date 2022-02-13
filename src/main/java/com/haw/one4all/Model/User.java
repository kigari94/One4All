package com.haw.one4all.Model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @NotEmpty(message ="Bitte gib einen gültigen Usernamen an.")
    @Size(min = 2, max = 20)
    @Column(nullable = false, unique = true, length = 45)
    private String username;

    @NotEmpty(message = "Bitte gib ein gültiges Passwort an.")
    @Size(min = 8, max = 60)
    @Column(nullable = false, length = 64)
    private String password;

    @Transient
    private String confirmPassword;

    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Project> projects;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
