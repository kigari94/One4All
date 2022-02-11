package com.haw.one4all.Model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Bitte gib einen Titel an.")
    @Size(min = 5, max = 60)
    @Column(nullable = false, length = 60)
    private String title;

    @NotEmpty(message = "Bitte gib die Projektart an.")
    @Size(min = 3, max = 12)
    @Column(nullable = false, length = 12)
    private String projectType;

    @NotEmpty(message = "Bitte gib eine Beschreibung an.")
    @Size(min = 10, max = 512)
    @Column(nullable = false, length = 512)
    private String description;

    @NotEmpty(message = "Bitte gib eine Kontaktmöglichkeit an.")
    @Size(min = 5, max = 32)
    @Column(nullable = false, length = 32)
    private String email;

    @Column(nullable = false, length = 32)
    private String crew;

    @Column(nullable = false, length = 20)
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
