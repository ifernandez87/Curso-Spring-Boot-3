package com.nacho.curso.springboot.webapp.springbootweb.controllers.Rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nacho.curso.springboot.webapp.springbootweb.models.User;

@RestController
@RequestMapping("/api")
public class PostMappingController {

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        // Process User
        return User.builder().name(user.getName().toUpperCase()).lastname(user.getLastname().toUpperCase())
                .email(user.getEmail()).build();
    }

}
