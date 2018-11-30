package com.example.demo.persistence;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Paweł on 2018-11-29.
 */
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
