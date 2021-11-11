package com.example.demo.controller;

import javax.servlet.http.HttpSession;

//import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping("/")
	public String viewHomePage (Model model) {
		return "index";
	}
	
	@GetMapping("/login")
	public String login (Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}
	
	@GetMapping("/index")
	public String signup (Model model) {
		return "redirect:/";
	}
	
	@PostMapping("/saveUser")
	public String saveNewUser(User user , HttpSession session) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		userRepository.save(user);
		session.setAttribute("message", "user registred successfully...");
        return "login";
	}
	
	
}
