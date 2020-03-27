package com.featurevote.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;  //used for auth below
                                                    //this is a interface in Spring security with one method only. Since it's a interface,
                                                    //we need to create the implementation

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

        //changed to the non-hard code mode
        auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(getPasswordEncoder());

        // not recommended to use this in production
/*        auth.inMemoryAuthentication()
            .passwordEncoder(getPasswordEncoder())
            .withUser("testing@gmail.com")
            .password(getPasswordEncoder().encode("1234567"))             //since using the encoder above, need to make sure that this password is also encoded.
            .roles("USER");*/
    }

    protected void configure(HttpSecurity http) throws Exception{
        http
            .authorizeRequests()
                .antMatchers("/").permitAll()   //permit all to see the root page
                .antMatchers("/register").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().hasRole("USER").and() //all other pages has to have a "USER" role
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/dashboard")
                .permitAll()
                .and()
            .logout()
                .logoutUrl("/logout")
                .permitAll();
    }


}
