package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dal.UserDAL;
import com.example.demo.dal.UserRepository;
import com.example.demo.model.User;

@RestController
public class UserController {
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final UserRepository userRepository;

	private final UserDAL userDAL;

	public UserController(UserRepository userRepository, UserDAL userDAL) {
		this.userRepository = userRepository;
		this.userDAL = userDAL;
	}

	@PostMapping(value = "/create")
	public User addNewUsers(@RequestBody User user) {
		LOG.info("Saving user.");
		return userRepository.save(user);
	}
	
	@GetMapping(value = "/getAllUsers")
	public List<User> getAllUsers() {
		LOG.info("getAllUsers");
		return userRepository.findAll();
	}
	@GetMapping(value = "/getAllUsersByMobile/{mobileNo}")
	public List<User> getAllUsersByMobile(@PathVariable String mobileNo) {
		LOG.info("getAllUsers"+mobileNo);
		return userDAL.getAllUsersByMobile(mobileNo);
	}
}
