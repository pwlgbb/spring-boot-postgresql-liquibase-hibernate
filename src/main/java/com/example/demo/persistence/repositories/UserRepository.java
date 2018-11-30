package com.example.demo.persistence.repositories;

import com.example.demo.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Paweł on 2018-11-30.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
}
