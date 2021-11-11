package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Meter;
import com.example.demo.model.MeterData;
import com.example.demo.repository.MeterDataRepository;
import com.example.demo.repository.MeterRepository;
//import com.example.demo.service.MeterDataService;

@Controller
@RequestMapping("/user")
public class MeterDataController {
		
	@Autowired
	private MeterRepository meterRepository;
	
	@Autowired
	private MeterDataRepository meterDataRepository;
	
//	@Autowired
//	private MeterDataService meterDataService;
	
	@GetMapping("/addMeterData")
	public String addMeterData(Model model) {
		List<Meter>listMeter = meterRepository.findAll();
		model.addAttribute("meterData", new MeterData());
		model.addAttribute("listMeter", listMeter);
		return "adding_data";
	}
	
	@PostMapping("/saveMeterData")
	public String saveMeterData(MeterData meterData) {
		meterDataRepository.save(meterData);	
		return "redirect:/user/seeHistory";
	}
	
	@GetMapping("/seeHistory")
	public String seeHistory(Model model) {
		List<MeterData>listMeterData = meterDataRepository.findAll();
		model.addAttribute("listMeterData", listMeterData);
		return "history";
	}	
}
