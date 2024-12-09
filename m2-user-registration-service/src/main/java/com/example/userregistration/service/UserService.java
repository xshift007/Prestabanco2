package com.example.userregistration.service;

import com.example.userregistration.entity.User;
import com.example.userregistration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Servicio para la lógica de negocio relacionada con los usuarios.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Registrar un nuevo usuario.
     */
    public User registerUser(User user) {
        // Podrías agregar validaciones aquí (ej. email único)
        return userRepository.save(user);
    }

    /**
     * Obtener un usuario por su ID.
     */
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
