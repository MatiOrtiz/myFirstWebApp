package com.masterspringspringboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello(){
        return "Good day! Beautiful morning, no?";
    }

}
