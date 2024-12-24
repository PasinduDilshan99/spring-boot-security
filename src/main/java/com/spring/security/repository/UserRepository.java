package com.spring.security.repository;

import com.spring.security.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {

    Users findByUsername(String username);
}
