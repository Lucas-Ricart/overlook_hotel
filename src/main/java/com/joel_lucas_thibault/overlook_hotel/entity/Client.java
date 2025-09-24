package com.joel_lucas_thibault.overlook_hotel.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Pour compatibilité Spring Security et code existant
    public String getPassword() { return motdepasse; }
    public void setPassword(String password) { this.motdepasse = password; }
    public String getUsername() { return mail; }
    public void setUsername(String username) { this.mail = username; }
    public String getEmail() { return mail; }
    public void setEmail(String email) { this.mail = email; }


    private String nom;
    private String prenom;
    private String mail;
    private String motdepasse;
    private Integer pointFidelite;
    private String salt;
    private String role; // 'CLIENT' par défaut


    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }

    public String getMotdepasse() { return motdepasse; }
    public void setMotdepasse(String motdepasse) { this.motdepasse = motdepasse; }

    public Integer getPointFidelite() { return pointFidelite; }
    public void setPointFidelite(Integer pointFidelite) { this.pointFidelite = pointFidelite; }

    public String getSalt() { return salt; }
    public void setSalt(String salt) { this.salt = salt; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Les méthodes getEmail/setEmail sont déjà redirigées vers 'mail'.
}
