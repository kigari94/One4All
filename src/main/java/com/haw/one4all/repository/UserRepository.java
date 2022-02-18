package com.haw.one4all.repository;

import com.haw.one4all.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, String> {

   @Query("SELECT u FROM User u WHERE u.username = ?1")
   User findByUsername(String username);


}
