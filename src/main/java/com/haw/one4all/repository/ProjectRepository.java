package com.haw.one4all.repository;

import com.haw.one4all.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    // required Methods save() and findAll() inherited form JPARepository

}
