package com.example.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.ApiEndpoint;
import com.example.demo.exception.ResouceNotFoundException;
import com.example.demo.model.Login;
import com.example.demo.service.LoginService;

@RestController
public class LoginController {

	private static final Logger LOGGER = LogManager.getLogger(LoginController.class); 
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping(value = ApiEndpoint.INSERT)
	public String inserData(@RequestBody Login login) {
		LOGGER.info("Login Data : " + login);
		loginService.addInsertData(login);
		LOGGER.info("Insert Login Data Operation Completed...!");
		return "Data Inserted";
	}
	
	@PostMapping(value = ApiEndpoint.INSERTDIFF)
	public String insertDifferntUserData(@RequestBody Login login) {
		LOGGER.info("Login Different Data : " + login);
		loginService.addDiffernetUser(login);
		LOGGER.info("Insert Different Login Data Operation Completed...!");
		return "Data Inserted";
	}
	
	@GetMapping(value = ApiEndpoint.LOGIN)
	public ResponseEntity<Login> getLoginData(@RequestParam String uname,@RequestParam String pass) throws ResouceNotFoundException {
		LOGGER.info("Login Process Start : " + uname + " " +  pass);
		Login login = loginService.getLoginData(uname, pass);
		return ResponseEntity.ok(login);
	}
}
