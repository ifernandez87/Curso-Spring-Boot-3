package es.ejemplo.manejo.excepciones.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.ejemplo.manejo.excepciones.models.domain.User;

@Service
public class UserServiceImpl implements UserService {

    private List<User> users;

    public UserServiceImpl() {
        this.users = new ArrayList<>();
        users.add(new User(1L, "Pepe", "Gonzalez", null));
        users.add(new User(2L, "Andres", "Lopez", null));
        users.add(new User(3L, "Ignacio", "Fernandez", null));
        users.add(new User(4L, "Lucas", "Perez", null));
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional<User> findById(Long id) {
        return users.stream().filter(u -> u.getId().equals(id)).findFirst();
    }

}
