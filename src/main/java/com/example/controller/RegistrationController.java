package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.SignupEntity;
import com.example.repository.RegistrationRepository;
import com.example.service.RegistrationService;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class RegistrationController {
	 @Autowired
	 private RegistrationService registrationservice;
	 
	 @PostMapping("/user/signup")
	 public ResponseEntity<String> signUpUser(@RequestBody SignupEntity entity) {
		return registrationservice.signUp(entity);
		 
	 }

	 @PostMapping("/user/login")
	 public ResponseEntity<String> loginUser(@RequestBody SignupEntity entity) {
	     return registrationservice.login(entity.getMail(), entity.getPassword());
	 }
}
