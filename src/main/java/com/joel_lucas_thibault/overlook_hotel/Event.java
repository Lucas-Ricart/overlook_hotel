package com.joel_lucas_thibault.overlook_hotel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "evenement")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "heure", nullable = false)
    private String heure;

    @Column(name = "prix", nullable = false)
    private Double prix;

    @Column(name = "place_dispo", nullable = false)
    private Integer place_dispo;

    @Column(name = "nb_reserver", nullable = true)
    private Integer nb_reserver;

    //@Column(name = "id_client_reservation", nullable = false)
    //private Long id_client_reservation;

    // Constructeurs, getters et setters

    public Event() {
    }

    public Event(String nom, String date, String heure, Double prix, Integer place_dispo, Integer nb_reserver) {
        this.nom = nom;
        this.date = date;
        this.heure = heure;
        this.prix = prix;
        this.place_dispo = place_dispo;
        this.nb_reserver = nb_reserver;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Integer getPlace_dispo() {
        return place_dispo;
    }

    public void setPlace_dispo(Integer place_dispo) {
        this.place_dispo = place_dispo;
    }

    public Integer getNb_reserver() {
        return nb_reserver;
    }

    public void setNb_reserver(Integer nb_reserver) {
        this.nb_reserver = nb_reserver;
    }

}