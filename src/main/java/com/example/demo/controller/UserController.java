package com.example.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.ApiEndpoint;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	
	private static final Logger LOGGER = LogManager.getLogger(UserController.class); 
	
	@Autowired
	UserService userService ;
	
	@PostMapping(value = ApiEndpoint.USER)
	public User createUser(@RequestBody User user){
		LOGGER.info("Create User Called..."+user);
		return userService.createUser(user); 
	}
	

}

