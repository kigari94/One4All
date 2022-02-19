package com.haw.one4all.service;

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

    public void saveUser(User user) {
        // Encrypting the user password given
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        // Save user in database
        userRepo.save(user);
    }

    public Boolean findUserByUsername(String username) {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            return  false;
        }
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new CustomUserDetails(user);
    }
}
