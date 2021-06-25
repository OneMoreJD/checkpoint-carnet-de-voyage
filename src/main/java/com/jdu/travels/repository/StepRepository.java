package com.jdu.travels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jdu.travels.entity.Step;

@Repository
public interface StepRepository extends JpaRepository<Step, Long> {

}
