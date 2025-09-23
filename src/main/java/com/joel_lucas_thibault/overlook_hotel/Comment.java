package com.joel_lucas_thibault.overlook_hotel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "evaluation")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "note", nullable = false)
    private String rate;

    @Column(name = "commentaire", nullable = false)
    private String comment;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "heure", nullable = false)
    private String time;

    public Comment() {}

    public Comment(String rate, String comment, String date, String time) {
        this.rate = rate;
        this.comment = comment;
        this.date = date;
        this.time = time;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRate() { return rate; }
    public void setRate(String rate) { this.rate = rate; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

}