package com.haw.one4all.repository;

import com.haw.one4all.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, String> {

    /* required Methods save() and findAll() inherited form JPARepository
       defining method findById with datatype Project */

   @Query("SELECT u FROM User u WHERE u.username = ?1")
   User findByUsername(String username);


}
