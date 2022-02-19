package com.haw.one4all.service;

import com.haw.one4all.Model.Project;
import com.haw.one4all.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepo;

    // saving object from type project
    public void saveProject(Project project) {
        projectRepo.save(project);
    }

    // finding all objects from type project
    public List<Project> findProjects() {
        return projectRepo.findAll();
    }

    // finding object from type project with specified id
    public Project findProjectById(long id) {
        return projectRepo.findById(id);
    }

    // finding all objects from type project with specified projectType
    public List<Project> findProjectsByType(String projectType) {
        return projectRepo.findAllByProjectType(projectType);
    }

    // deleting object from type project with specified id
    public void deleteProjectById(long id) {
        projectRepo.deleteById(id);
    }
}
