package es.ejemplo.manejo.excepciones.services;

import java.util.List;
import java.util.Optional;

import es.ejemplo.manejo.excepciones.models.domain.User;

public interface UserService {

    List<User> findAll();
    Optional<User> findById(Long id);
}
