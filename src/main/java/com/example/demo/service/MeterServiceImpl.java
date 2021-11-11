package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Meter;
import com.example.demo.repository.MeterRepository;

@Service
public class MeterServiceImpl implements MeterService {

	@Autowired
	private MeterRepository meterRepository;
	
	@Override
	public List<Meter> getAllMeters() {
		return meterRepository.findAll();
	}

	@Override
	public void saveMeter(Meter meter) {
		this.meterRepository.save(meter);
	}

	@Override
	public Meter getMeterById(long id) {
		Optional<Meter> optional = meterRepository.findById(id);
		Meter meter = null;
		if(optional.isPresent()) {
			meter = optional.get();
		}else {
			throw new RuntimeException("Meter not found for id :: " + id);
		}
		return meter;
	}

	@Override
	public void deleteMeterById(long id) {
		this.meterRepository.deleteById(id);
	}

}
