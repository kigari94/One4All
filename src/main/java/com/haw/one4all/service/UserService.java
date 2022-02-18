package com.haw.one4all.service;

import com.haw.one4all.Model.Project;
import com.haw.one4all.Model.User;
import com.haw.one4all.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    public void saveUser(User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);
    }

    /*
    public void saveFavorite(User user, String favorite){
//        user.setFavoriteProjects(favorite);
        userRepo.save(user);
    }*/

    /*
    public User findUserByUsername(String username){
        System.out.println("pass________________: ");
        User user = userRepo.findByUsername(username);
        return user;
    }*/

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }
}
