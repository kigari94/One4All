package com.haw.one4all;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.haw.one4all.Model.Project;
import com.haw.one4all.Model.User;
import com.haw.one4all.repository.ProjectRepository;
import com.haw.one4all.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class RepositoriesTests {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ProjectRepository projectRepo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setUsername("Max Muster");
        user.setPassword("TesterTester!");

        // Saving via userRepo
        User savedUser = userRepo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getUsername());

        // Verify user is existing
        assertEquals(existUser.getUsername(), user.getUsername());

        String username = "Max Muster";
        User loadedUser = userRepo.findByUsername(username);

        // Verify user is not null
        assertThat(loadedUser).isNotNull();

    }

//    @Test
//    public void testFindUserByUsername() {
//        String username = "Max Muster";
//        User user = userRepo.findByUsername(username);
//
//        // Verify user is not null
//        assertThat(user).isNotNull();
//    }

    @Test
    public void testCreateProject() {
        Project project = new Project();
        User user = new User();
        ArrayList<String> usersFavorite = new ArrayList<String>();
        usersFavorite.add("Max Muster");
        user.setUsername("MaxMuster");
        user.setPassword("TesterTester!");
        userRepo.save(user);

        project.setProjectId(1L);
        project.setProjectType("ProjektA");
        project.setCrew("Dev");
        project.setTitle("Test");
        project.setDescription("Lorem ipsum");
        project.setEmail("test@test.com");
        project.setUser(user);
        project.setUsersFavorite(usersFavorite);

        Project savedProject = projectRepo.save(project);

        Project existProject = entityManager.find(Project.class, savedProject.getProjectId());

        // Verify project attributes are saved
        assertEquals(existProject.getProjectId(), project.getProjectId());
        assertEquals(existProject.getProjectType(), project.getProjectType());
        assertEquals(existProject.getCrew(), project.getCrew());
        assertEquals(existProject.getTitle(), project.getTitle());
        assertEquals(existProject.getDescription(), project.getDescription());
        assertEquals(existProject.getEmail(), project.getEmail());
        assertEquals(existProject.getUser().getUsername(), project.getUser().getUsername());
        assertEquals(existProject.getUsersFavorite(), project.getUsersFavorite());

        Long id = 1L;
        Optional<Project> loadedProject = projectRepo.findById(id);

        // verify project is not null
        assertThat(loadedProject).isNotNull();
    }

//    @Test
//    public void testFindProjectById() {
//        Long id = 1L;
//        Optional<Project> project = projectRepo.findById(id);
//
//        // verify project is not null
//        assertThat(project).isNotNull();
//    }
}
