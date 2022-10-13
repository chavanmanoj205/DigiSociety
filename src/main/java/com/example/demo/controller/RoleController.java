package com.example.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.ApiEndpoint;
import com.example.demo.model.Role;
import com.example.demo.service.RoleService;

@RestController
public class RoleController {

	private static final Logger LOGGER = LogManager.getLogger(RoleController.class); 
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping(value = ApiEndpoint.ROLEADD)
	public String addRoleData(@RequestBody Role role) {
		LOGGER.info("Check Role Data : " + role);
		roleService.addRoleData(role);
		LOGGER.info("Role Data Operation Completed....!");
		return "Role Added";
	}
	
}
