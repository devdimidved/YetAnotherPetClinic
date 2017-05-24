package me.devdimidved.playground.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @RequestMapping("/")
    String home(ModelMap model) {
        model.addAttribute("title", "Yet another Pet Clinic");
        return "index";
    }
}
