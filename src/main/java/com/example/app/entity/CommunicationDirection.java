package com.example.app.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "communication_direction")
@Data
public class CommunicationDirection {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
}
