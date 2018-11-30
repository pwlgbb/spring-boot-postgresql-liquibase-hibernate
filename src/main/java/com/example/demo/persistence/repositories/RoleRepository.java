package com.example.demo.persistence.repositories;

import com.example.demo.persistence.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Paweł on 2018-11-30.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
