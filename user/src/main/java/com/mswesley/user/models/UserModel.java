package com.mswesley.user.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.UUID;

@Entity
@Table(name = "TB_USER")
public class UserModel {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    @Email(message = "Email incorreto")
    private String email;

    public UserModel(){}

    public UserModel(UUID id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}