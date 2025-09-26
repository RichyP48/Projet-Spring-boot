package com.mogou.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Tableau de bord");
        model.addAttribute("userName", "Alex Dupont");
        return "index"; // résout templates/index.html
    }
}
