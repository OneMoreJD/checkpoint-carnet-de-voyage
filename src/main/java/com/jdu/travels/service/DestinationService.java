package com.jdu.travels.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdu.travels.dto.DestinationDTO;
import com.jdu.travels.entity.Destination;
import com.jdu.travels.repository.DestinationRepository;

@Service
public class DestinationService {

    @Autowired
    DestinationRepository repo;
    
    public Boolean create(DestinationDTO dto) {
        try {
            repo.save(mapDestinationDTOtoDestination(dto));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public List<Destination> getAll() {
        return repo.findAll();
    }
    
    public DestinationDTO get(long id) {
        return mapDestinationToDestinationDTO(repo.getOne(id));
    }
    
    public Destination update(DestinationDTO dto) {
        Destination destination = repo.getOne(dto.getId());
        destination = mapDestinationDTOtoDestination(dto);
        return repo.save(destination);
    }

    public Boolean delete(long id) {
        Optional<Destination> d = repo.findById(id);
        if (d.isPresent()) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
    
    

    private Destination mapDestinationDTOtoDestination(DestinationDTO dto) {
        Destination d = new Destination();
        d.setId(dto.getId());
        d.setCountry(dto.getCountry());
        d.setStartDate(dto.getStartDate());
        d.setEndDate(dto.getEndDate());
        d.setSteps(dto.getSteps());
        return d;
    }

    private DestinationDTO mapDestinationToDestinationDTO(Destination d) {
        DestinationDTO dto = new DestinationDTO(d.getId(), d.getCountry(), d.getStartDate(), d.getEndDate(), d.getSteps());
        return dto;
    }
}
