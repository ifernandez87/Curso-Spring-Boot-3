package com.nacho.curso.springboot.webapp.springbootweb.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
        User user = new User("Ignacio", "Fernandez Sanchez", "ignaciofs87@gmail.com");
        Map<String, Object> body = new HashMap<String, Object>();

        body.put("title", "Hola Mundo Spring boot");
        body.put("user", user);

        return body;
    }

    @GetMapping("/details-dto")
    public UserDto detailsDto() {
        User user = new User("Ignacio", "Fernandez Sanchez", "ignaciofs87@gmail.com");

        UserDto userDto = new UserDto("Hola Mundo Spring Boot", user.getName(), user.getLastname());
        return userDto;
    }

    @GetMapping("/details-list")
    public List<User> list() {
        User user1 = new User("Ignacio", "Fernandez Sanchez", "ignaciofs87@gmail.com");
        User user2 = new User("Minerva", "Gonzalez Velasco", "minerva_88md@hotmail.com");
        User user3 = new User("Martina", "Fernandez Gonzalez", null);

        List<User> users = Arrays.asList(user1, user2, user3);
        return users;
    }

}
