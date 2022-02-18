package com.haw.one4all.repository;

import com.haw.one4all.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.ResultSet;
import java.sql.SQLException;


public interface UserRepository extends JpaRepository<User, String> {

   //@Query(value = "SELECT u FROM Users u WHERE u.username = ?1", nativeQuery = true)
   @Query(value = "SELECT u FROM User u WHERE u.username = :username")
   User findByUsername(String username);


}
