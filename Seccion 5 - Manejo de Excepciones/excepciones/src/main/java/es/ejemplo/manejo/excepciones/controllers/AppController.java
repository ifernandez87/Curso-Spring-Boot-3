package es.ejemplo.manejo.excepciones.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.ejemplo.manejo.excepciones.exceptions.UserNotFoundException;
import es.ejemplo.manejo.excepciones.models.domain.User;
import es.ejemplo.manejo.excepciones.services.UserService;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String index() {
        int value = (Integer.parseInt("12x"));
        System.out.println(value);
        return "ok 200";
    }

    @GetMapping("/users/{id}")
    public User getUsersById(@PathVariable(name = "id") Long id) {
        return userService.findById(id).orElseThrow(() -> new UserNotFoundException("Error el usuario no existe"));
    }

}
