package com.example.demo.service;

import java.util.List;

import com.example.demo.model.MeterData;

public interface MeterDataService {
	List<MeterData>getAllMeters();
	void saveMeterData(MeterData meterData);
	MeterData getMeterDataById(long id);
}
