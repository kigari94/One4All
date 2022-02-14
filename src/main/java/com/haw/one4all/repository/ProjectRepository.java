package com.haw.one4all.repository;

import com.haw.one4all.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    // required Methods save() and findAll() inherited form JPARepository
    // defining method findById with datatype Project
    Project findById(long id);

    List<Project> findAllByProjectType(String projectType);
}
