package com.example.app.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_role")
@Data
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "user_role_user_permission",
            joinColumns = @JoinColumn(name = "user_role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_permission_id"))
    private List<UserPermission> userPermissions;
}
