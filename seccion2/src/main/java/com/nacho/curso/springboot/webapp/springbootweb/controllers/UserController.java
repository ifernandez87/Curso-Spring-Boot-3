package com.nacho.curso.springboot.webapp.springbootweb.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nacho.curso.springboot.webapp.springbootweb.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public Map<String, Object> details(Model model) {

        User user = new User("Ignacio", "Fernandez Sanchez", null);

        Map<String, Object> body = new HashMap<String, Object>();

        body.put("title", "Hola Mundo Spring boot");
        body.put("user", user);

        return body;
    }

    @GetMapping("/list")
    public String list(ModelMap modelMap) {
        modelMap.addAttribute("title", "Listado de usuarios");
        return "list";
    }

    /**
     * ModelAtribute para pasar datos a la lista,datos comunes a todas las vistas.
     * 
     * @return Datos comunes a todas las vistas.
     */
    @ModelAttribute("users")
    public List<User> usersModel() {
        User user1 = new User("Ignacio", "Fernandez Sanchez", "ignaciofs87@gmail.com");
        User user2 = new User("Minerva", "Gonzalez Velasco", "minerva_88md@hotmail.com");
        User user3 = new User("Martina", "Fernandez Gonzalez", null);
        return Arrays.asList(user1, user2, user3);
    }

}
