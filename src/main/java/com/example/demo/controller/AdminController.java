package com.example.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Owner;
import com.example.demo.service.AdminService;

@RestController
public class AdminController {
	
	private static final Logger LOGGER = LogManager.getLogger(AdminController.class); 

	@Autowired
	private AdminService adminService;
	
	@PostMapping(value = "/regFlat/{aname}/{ownerName}/{buildingNo}/{flatNo}")
	public Owner allocateFlatData(@PathVariable String aname,@PathVariable String ownerName,@PathVariable String buildingNo,@PathVariable int flatNo) {
	Owner owner = adminService.addflattoOwner(aname, ownerName, buildingNo, flatNo);
	return owner;
	}

}
