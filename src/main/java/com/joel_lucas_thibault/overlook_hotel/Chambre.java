package com.joel_lucas_thibault.overlook_hotel;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "chambre")
@Data
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero", nullable = false)
    private String numero;

    @Column(name = "nb_personne", nullable = false)
    private Integer nb_personne;

    @Column(name = "prix", nullable = false)
    private Double prix;

    @Column(name = "disponible", nullable = false)
    private Boolean disponible;

    @Column(name = "id_client_reservation")
    private Long id_client_reservation;

    // Constructeurs, getters et setters

    public Chambre() {
    }

    public Chambre(String numero, Integer nb_personne, Double prix) {
        this.numero = numero;
        this.nb_personne = nb_personne;
        this.prix = prix;
        this.disponible = true; // Par défaut, une chambre est disponible
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getNb_personne() {
        return nb_personne;
    }

    public void setNb_personne(Integer nb_personne) {
        this.nb_personne = nb_personne;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Long getId_client_reservation() {
        return id_client_reservation;
    }

    public void setId_client_reservation(Long id_client_reservation) {
        this.id_client_reservation = id_client_reservation;
    }
}