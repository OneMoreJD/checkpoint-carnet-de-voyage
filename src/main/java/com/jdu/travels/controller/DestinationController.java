package com.jdu.travels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jdu.travels.dto.DestinationDTO;
import com.jdu.travels.entity.Destination;
import com.jdu.travels.service.DestinationService;

@Controller
public class DestinationController {

    @Autowired
    DestinationService destinationService;
    
    @GetMapping("/dest/{id}")
    @ResponseBody
    public DestinationDTO getDestination(@PathVariable int id) {
        DestinationDTO dto = destinationService.get(id);
        return dto;
    }
    
    @GetMapping("/dest")
    public String getCreateDestinationPage(Model model) {
        return "create-dest";
    }

    @PostMapping("/dest")
    @ResponseBody
    public String postDestinationForCreation(@ModelAttribute DestinationDTO dto) {
        Boolean success = destinationService.create(dto);
        return "redirect:/";
    }

    @PostMapping("/dest/update")
    @ResponseBody
    public ResponseEntity<Destination> postDestinationForUpdate(@ModelAttribute DestinationDTO dto) {
        Destination d = destinationService.update(dto);
        return new ResponseEntity<Destination>(d, HttpStatus.OK);
    }

    @DeleteMapping("/dest/{id}")
    @ResponseBody
    public ResponseEntity<Integer> deleteDestination(@PathVariable int id) {
        Boolean isRemoved = destinationService.delete(id);
        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
