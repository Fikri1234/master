package com.java.webdev.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by M Nurul Fikri on 07/01/2018
 */
@Controller
public class MUserController {
    @RequestMapping("/User/")
    public String userCreate(){
        return "userCreate";
    }

    /*------------------ starting test inject via application.properties ------------------*/
    @Value("${testPage.message:test}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "testPage";
    }
    /*------------------ end of test inject via application.properties -----------------*/
}
