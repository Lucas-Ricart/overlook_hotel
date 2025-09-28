package com.joel_lucas_thibault.overlook_hotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "time", nullable = false)
    private String time;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "available_slots", nullable = false)
    private Integer availableSlots;

    @Column(name = "booked_slots", nullable = true)
    private Integer booked_Slots;

    public Event() {}

    public Event(String name, String date, String time, Double price, Integer availableSlots, Integer booked_Slots) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.price = price;
        this.availableSlots = availableSlots;
        this.booked_Slots = booked_Slots;
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

    public Integer getAvailableSlots() { return availableSlots; }
    public void setAvailableSlots(Integer availableSlots) { this.availableSlots = availableSlots; }

    public Integer getBooked_Slots() { return booked_Slots; }
    public void setBooked_Slots(Integer booked_Slots) { this.booked_Slots = booked_Slots; }
}