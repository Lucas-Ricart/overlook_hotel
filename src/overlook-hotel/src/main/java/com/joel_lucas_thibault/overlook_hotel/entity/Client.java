package com.joel_lucas_thibault.overlook_hotel.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "client")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false, unique = true)
    private String mail;

    @Column(nullable = false)
    private String motdepasse; // Hashé avec BCrypt

    @Column(name = "point_fidelite", nullable = false)
    private Integer pointFidelite = 0;

    private String salt; // Optionnel, pour ancien hashing ; BCrypt n'en a pas besoin
}