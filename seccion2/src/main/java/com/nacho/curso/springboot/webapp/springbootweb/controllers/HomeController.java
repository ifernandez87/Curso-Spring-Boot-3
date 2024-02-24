package com.nacho.curso.springboot.webapp.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({ "", "/", "/home" })
    public String home() {
        // Redirect
        // Reinicia el Request --> Genera una nueva peticion.
        // return "redirect:/details";

        // Forward
        // Mantiene la ruta original
        return "forward:/details";
    }

}
