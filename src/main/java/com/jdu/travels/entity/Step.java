package com.jdu.travels.entity;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional=false)
    @JoinColumn(name = "destination_id", nullable=false)
    private Destination destination;
    
    private LocalDate date;
    
    @Column(length=255)
    private String description;
    
    private ArrayList<String> links;

    public Step() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long aId) {
        id = aId;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination aDestination) {
        destination = aDestination;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate aDate) {
        date = aDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String aDescription) {
        description = aDescription;
    }

    public ArrayList<String> getLinks() {
        return links;
    }

    public void setLinks(ArrayList<String> aLinks) {
        links = aLinks;
    }
    
}
