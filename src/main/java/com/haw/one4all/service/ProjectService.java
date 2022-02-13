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

    // saving Object from type Project
    public void saveProject(Project project){
        projectRepo.save(project);
    }

    // finding all Objects from type Project
    public List<Project> findProjects(){
        return projectRepo.findAll();
    }

    // finding Object from type Project with specified id
    public Project findProjectById(long id){
        Project project = projectRepo.findById(id);
        return project;
    }
}
