package com.haw.one4all;

import static org.assertj.core.api.Assertions.assertThat;

import com.haw.one4all.Model.User;
import com.haw.one4all.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setUsername("Max Muster");
        user.setPassword("TesterTester!");

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getUsername());

        assertThat(existUser.getUsername().equals(user.getUsername()));
    }

    @Test
    public void testFindUserByUsername() {
        String username = "Max Muster";
        User user = repo.findByUsername(username);

        assertThat(user).isNotNull();
    }
}
