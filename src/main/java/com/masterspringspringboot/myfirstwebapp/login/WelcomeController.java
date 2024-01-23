package com.masterspringspringboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

    private LoginAuthenticationService authenticationService;
    public WelcomeController(LoginAuthenticationService authenticationService){
        super();
        this.authenticationService= authenticationService;
    }

    @RequestMapping(value = "/", method= RequestMethod.GET)
    public String goToWelcomePage(ModelMap modelMap){
        modelMap.put("name", "admin");
        return "welcome";
    }

}
