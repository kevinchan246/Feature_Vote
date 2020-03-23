package com.featurevote.repositories;

import com.featurevote.domain.User;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);   // finding use by the username field inside User object
}
