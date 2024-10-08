package de.c24.finacc.klt.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * IndexController
 */
@Controller
@RequiredArgsConstructor
public class IndexController {

    /**
     * Index endpoint to show the index page
     *
     * @param model Spring's view model
     * @return view name
     */



    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("title", "Karten&Konten KLT");
        model.addAttribute("welcome", "Welcome to Check24");
        model.addAttribute("applicationTitle", "Bogdan`s Check24 Currency Converter");
        return "index";
    }
}
