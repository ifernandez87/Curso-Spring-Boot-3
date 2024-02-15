package com.nacho.curso.springboot.webapp.springbootweb.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nacho.curso.springboot.webapp.springbootweb.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public Map<String, Object> details(Model model) {

        User user = new User("Ignacio", "Fernandez Sanchez");

        Map<String, Object> body = new HashMap<String, Object>();

        body.put("title", "Hola Mundo Spring boot");
        body.put("user", user);

        return body;
    }

}
