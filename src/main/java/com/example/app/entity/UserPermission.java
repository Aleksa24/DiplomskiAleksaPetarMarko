package com.example.app.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_permission")
@Data
public class UserPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}
