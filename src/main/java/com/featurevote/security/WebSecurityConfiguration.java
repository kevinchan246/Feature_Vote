package com.featurevote.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication() // not recommmended to use this in production
            .passwordEncoder(getPasswordEncoder())
            .withUser("testing@gmail.com")
            .password(getPasswordEncoder().encode("1234567"))                        //since using the encoder above, need to make sure that this password is also encoded.
            .roles("USER");
    }

    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers("/").permitAll()   //permit all to see the root page
                .antMatchers("/login").permitAll()  //permit all to see the login page
                .anyRequest().hasRole("USER").and() //all other pages has to have a "USER" role
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .logoutUrl("/logout")
                .permitAll();
    }


}
