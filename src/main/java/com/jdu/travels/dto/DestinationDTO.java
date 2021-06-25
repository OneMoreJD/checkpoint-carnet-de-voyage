package com.jdu.travels.dto;

import java.time.LocalDate;
import java.util.List;

import com.jdu.travels.entity.Step;


public class DestinationDTO {
    private Long id;
    private String country;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Step> steps;
    
    public DestinationDTO(Long aId, String country, LocalDate aStartDate, LocalDate aEndDate, List<Step> aSteps) {
        id = aId;
        this.country = country;
        startDate = aStartDate;
        endDate = aEndDate;
        steps = aSteps;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long aId) {
        id = aId;
    }
    
    public String getCountry() {
        return country;
    }

    public void setCountry(String aCountry) {
        country = aCountry;
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
    public List<Step> getSteps() {
        return steps;
    }
    public void setSteps(List<Step> aSteps) {
        steps = aSteps;
    }
}
