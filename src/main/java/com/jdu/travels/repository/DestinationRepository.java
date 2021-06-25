package com.jdu.travels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jdu.travels.entity.Destination;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {

}
