package com.joel_lucas_thibault.overlook_hotel.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employer")
@Data
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private String role; // Ex: "admin", "employee"

    @Column(nullable = false, unique = true)
    private String mail;

    @Column(nullable = false)
    private String motdepasse; // Hashé avec BCrypt

    private String salt;
}