package com.mingeso.m2userregistrationservice.repositories;

import com.mingeso.m2userregistrationservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
