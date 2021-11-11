package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.MeterData;

@Repository
public interface MeterDataRepository extends JpaRepository<MeterData, Long> {

}
