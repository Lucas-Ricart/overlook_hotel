package com.joel_lucas_thibault.overlook_hotel.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee") // doit correspondre à la table dans ta BDD
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String role;        // ex : "EMPLOYEE" ou "ADMIN"
    private String mail;        // login
    private String motdepasse;  // mot de passe haché

    public Long getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getRole() { return role; }
    public String getMail() { return mail; }
    public String getMotdepasse() { return motdepasse; }

    public void setId(Long id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setRole(String role) { this.role = role; }
    public void setMail(String mail) { this.mail = mail; }
    public void setMotdepasse(String motdepasse) { this.motdepasse = motdepasse; }
}
