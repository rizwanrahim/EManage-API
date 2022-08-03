package com.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.*;

@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String email;
    private String imageUrl;
    private String username;
    private String password;
    @ElementCollection
    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles;
    public Employee() {}

    public Employee(Long id, String name, String email, String imageUrl, Collection<Role> roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.imageUrl = imageUrl;
        this.roles = new ArrayList<>();
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
