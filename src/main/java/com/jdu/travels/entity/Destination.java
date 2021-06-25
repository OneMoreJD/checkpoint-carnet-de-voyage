package com.jdu.travels.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Destination {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL)
    private List<Step> steps;
    
    private LocalDate startDate;
    
    private LocalDate endDate;

    public Destination() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long aId) {
        id = aId;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> aSteps) {
        steps = aSteps;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate aStartDate) {
        startDate = aStartDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate aEndDate) {
        endDate = aEndDate;
    }

}
