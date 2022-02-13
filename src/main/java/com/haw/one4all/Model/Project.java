package com.haw.one4all.Model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long projectId;

    @NotEmpty(message = "Bitte gib einen Titel an.")
    @Size(min = 4, max = 32)
    @Column(nullable = false, length = 32)
    private String title;

    @NotEmpty(message = "Bitte gib die Projektart an.")
    @Size(min = 3, max = 36)
    @Column(nullable = false, length = 36)
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

    @ManyToOne
    @JoinColumn(name = "username", nullable=false)
    private User user;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
