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
    private String name;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "heure", nullable = false)
    private String time;

    @Column(name = "prix", nullable = false)
    private Double price;

    @Column(name = "place_dispo", nullable = false)
    private Integer availableSeats;

    @Column(name = "nb_reserver", nullable = true)
    private Integer reservations;

    public Event() {}

    public Event(String name, String date, String time, Double price, Integer availableSeats, Integer reservations) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.price = price;
        this.availableSeats = availableSeats;
        this.reservations = reservations;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Integer getAvailableSeats() { return availableSeats; }
    public void setAvailableSeats(Integer availableSeats) { this.availableSeats = availableSeats; }

    public Integer getReservations() { return reservations; }
    public void setReservations(Integer reservations) { this.reservations = reservations; }
}