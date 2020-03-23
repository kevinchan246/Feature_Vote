package com.featurevote.service;

import com.featurevote.domain.User;
import com.featurevote.repositories.UserRepository;
import com.featurevote.security.CustomSecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    //look up the user see if the database has this user w/ username, if exists, needs to check the password see if matches
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username); //loaded from database

        if (user == null) throw new UsernameNotFoundException("Invalid username and password");


        return new CustomSecurityUser(user);

    }
}
