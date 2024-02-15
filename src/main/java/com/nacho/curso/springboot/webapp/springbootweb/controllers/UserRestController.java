package com.nacho.curso.springboot.webapp.springbootweb.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nacho.curso.springboot.webapp.springbootweb.models.User;
import com.nacho.curso.springboot.webapp.springbootweb.models.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details-map")
    public Map<String, Object> detailsMap() {
        User user = new User("Ignacio", "Fernandez Sanchez");
        Map<String, Object> body = new HashMap<String, Object>();

        body.put("title", "Hola Mundo Spring boot");
        body.put("user", user);

        return body;
    }

    @GetMapping("/details-dto")
    public UserDto detailsDto() {
        User user = new User("Ignacio", "Fernandez Sanchez");

        UserDto userDto = new UserDto("Hola Mundo Spring Boot", user.getName(), user.getLastname());
        return userDto;
    }

}
