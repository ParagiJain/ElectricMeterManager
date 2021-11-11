package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Meter;

public interface MeterService {
	
	List<Meter>getAllMeters();
	void saveMeter(Meter meter);
	Meter getMeterById(long id);
	void deleteMeterById(long id);
}
