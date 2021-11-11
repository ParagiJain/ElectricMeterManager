package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Meter;

@Repository
public interface MeterRepository extends JpaRepository<Meter, Long>{

}

