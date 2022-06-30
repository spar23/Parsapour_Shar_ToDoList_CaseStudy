package com.shar.casestudy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    @GetMapping(value = {"/", "index"})
    public String homePage(){
        return  "redirect:/todoitem";
    }

    @GetMapping(value = {"/settings"})
    public String settingsPage(){
        return "settings";
    }

    @GetMapping(value = {"/about"})
    public String aboutPage(){
        return "about";
    }


}
