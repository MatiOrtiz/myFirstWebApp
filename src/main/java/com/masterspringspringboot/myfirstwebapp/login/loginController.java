package com.masterspringspringboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class loginController {

    @RequestMapping(value = "login", method= RequestMethod.GET)
    public String goToLoginPage(){
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap modelMap){
        modelMap.put("name", name);
        modelMap.put("password", password);
        return "welcome";
    }

}
