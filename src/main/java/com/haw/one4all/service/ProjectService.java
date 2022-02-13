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

    public void saveProject(Project project){
        projectRepo.save(project);
    }

    public List<Project> findProjects(){
        return projectRepo.findAll();
    }
}
