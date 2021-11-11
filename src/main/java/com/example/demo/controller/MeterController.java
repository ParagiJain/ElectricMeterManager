package com.example.demo.controller;

import java.security.Principal;

//import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Meter;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
//import com.example.demo.model.User;
//import com.example.demo.repository.UserRepository;
import com.example.demo.service.MeterService;

@Controller
@RequestMapping("/user")
public class MeterController {

	@Autowired
	private MeterService meterService;
	
	@Autowired 
	private UserRepository userRepository;
	
	//display meter list
	@GetMapping("/Signin")
	public String login (Principal p, Model model) {
		String email = p.getName();
		User user = userRepository.findByEmail(email);
		model.addAttribute("listMeter", meterService.getAllMeters());
		model.addAttribute("name", user.getName());
		return "meters";
	}
	
	@GetMapping("/addMeter")
	public String addMeter(Model model) {
		//create model attribute to bind form data
		Meter meter = new Meter();
		model.addAttribute("meter", meter);
		return "new_meter";
	}
	
	@PostMapping("/saveMeter")
	public String saveMeter(@ModelAttribute("meter") Meter meter) {
        // save employee to database
        meterService.saveMeter(meter);
        return "redirect:/user/Signin";
	}
	
	@GetMapping("/deleteMeter/{id}")
	public String deleteMeter(@PathVariable (value = "id") long id) {
		//call delete meter method
		this.meterService.deleteMeterById(id);
		return "redirect:/user/Signin";
	}
}
