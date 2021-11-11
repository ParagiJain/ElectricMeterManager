package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Meter;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
 	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
//
//	@Override
//	public User getUserByEmail(String email) {
//		Optional<User> optional = userRepository.findByEmail(email);
//		User user = null;
//		if(optional.isPresent()) {
//			user = optional.get();
//		}else {
//			throw new RuntimeException("User not found for email :: " + email);
//		}
//		return user;
//	}
//	
	

}
