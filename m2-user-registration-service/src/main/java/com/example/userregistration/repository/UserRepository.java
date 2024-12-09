package com.example.userregistration.repository;

import com.example.userregistration.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para la entidad User.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Se pueden agregar métodos de búsqueda personalizados, si es necesario
}
