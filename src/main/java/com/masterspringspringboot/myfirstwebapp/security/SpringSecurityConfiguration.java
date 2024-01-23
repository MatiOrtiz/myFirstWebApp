package com.masterspringspringboot.myfirstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager createUserDetailManager(){

        UserDetails userDetails = createNewUser("admin", "admin");
        UserDetails userDetails1= createNewUser("admin1", "admin1");
        return new InMemoryUserDetailsManager(userDetails, userDetails1);
    }

    private UserDetails createNewUser(String username, String password) {
        Function<String,String> passwordEncoder= input -> passwordEncoder().encode(input);

        UserDetails userDetails= User.builder()
                .passwordEncoder(passwordEncoder)
                .username(username)
                .password(password)
                .roles("USER","ADMIN")
                .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
