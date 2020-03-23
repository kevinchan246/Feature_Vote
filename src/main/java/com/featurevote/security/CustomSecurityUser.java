package com.featurevote.security;

import com.featurevote.domain.User;
import org.springframework.security.authentication.jaas.AuthorityGranter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CustomSecurityUser extends User implements UserDetails {

    private static final long serialVersionUID = -7929091683411336961L;
    Set<Authority> authorities = new HashSet<>();

    public CustomSecurityUser(){    } //NULL argument constructor: need this if you have the below type constructor with argument in it (because of Spring)
    public CustomSecurityUser(User user) {
        this.setId(user.getId());
        this.setName(user.getName());
        this.setUsername(user.getUsername());
        this.setPassword(user.getPassword());
        this.setAuthorities(user.getAuthorities());

    }

    //Spring security requires us to implement the following methods


    @Override
    public Set<Authority> getAuthorities() {
        //same as getPassword()
        return super.getAuthorities();
    }   //use super.getxxx because need to let the it know to call the method from the User object we created before

    @Override
    public String getPassword() {
        //the getPassword() method already exists in our User object, so we just call that method inside this method
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        //same as getPassword()
        return super.getUsername();
    }

    //following methods are used to determine if the user is active
    //if any of them return false, we not authorizing them to log in
    //hard coded to true for now.
    @Override
    public boolean isAccountNonExpired() {
        //originally false
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //originally false
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //originally false
        return true;
    }

    @Override
    public boolean isEnabled() {
        //originally false
        return true;
    }
}
