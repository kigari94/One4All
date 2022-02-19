package com.haw.one4all.service;

import com.haw.one4all.Model.Project;
import com.haw.one4all.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepo;

    // saving object from type project
    public void saveProject(Project project){
        projectRepo.save(project);
    }

    // finding all objects from type project
    public List<Project> findProjects(){
        return projectRepo.findAll();
    }

    // find all projects a user marked as favorite
    public ArrayList<Project> findFavoriteProjects(String username){
        ArrayList<Project> favProjects = new ArrayList<>();
        for(int i=0; i < findProjects().size(); i++){
            if (findProjects().get(i).getUsersFavorite().contains(username)){
                favProjects.add(findProjects().get(i));
            }
        }
        return favProjects;
    }

    // finding object from type project with specified id
    public Project findProjectById(long id){
        Project project = projectRepo.findById(id);
        return project;
    }

    // finding all objects from type project with specified projectType
    public List<Project> findProjectsByType(String projectType){
        return projectRepo.findAllByProjectType(projectType);
    }

    // deleting object from type project with specified id
    public void deleteProjectById(long id){
        projectRepo.deleteById(id);
    }

    //check if user already favorized the project
    public boolean isFavorized(Project project, String username){
        return project.getUsersFavorite().contains(username);
    }

    // add one user to the list of users who favorized it
    public void addUserFavorite(Project project, String username){
        if (!isFavorized(project, username)){
            project.addUsersFavorite(username);
            projectRepo.save(project);
        }
    }

    // delete one user from favorites
    public void deleteUserFavorite(Project project, String username){
        ArrayList<String> tempList = new ArrayList<>();
        for(int i=0; i < project.getUsersFavorite().size(); i++){
            if (!project.getUsersFavorite().get(i).equals(username)){
                tempList.add(project.getUsersFavorite().get(i));
            }
        }
        project.setUsersFavorite(tempList);
        projectRepo.save(project);
    }
}
