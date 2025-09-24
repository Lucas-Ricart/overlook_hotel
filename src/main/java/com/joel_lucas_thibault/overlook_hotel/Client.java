package com.joel_lucas_thibault.overlook_hotel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", nullable = false)
    private String name;

    @Column(name = "prenom", nullable = false)
    private String firstName;

    @Column(name = "mail", nullable = false)
    private String email;

    @Column(name = "motdepasse", nullable = false)
    private String password;

    @Column(name = "point_fidelite", nullable = false)
    private Integer fidelityPoints;

    public Client() {}

    public Client(String name, String firstName, String email, String password, Integer fidelityPoints) {
        this.name = name;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.fidelityPoints = fidelityPoints;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Integer getFidelityPoints() { return fidelityPoints; }
    public void setFidelityPoints(Integer fidelityPoints) { this.fidelityPoints = fidelityPoints; }
}