package com.masterspringspringboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class LoginAuthenticationService {
    public boolean authenticate(String userName, String password){
        boolean validUserName= userName.equalsIgnoreCase("admin");
        boolean validPassword= password.equalsIgnoreCase("admin");

        return validUserName && validPassword;
    }
}
