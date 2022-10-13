package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Role;

public interface RoleService {

	void addRoleData(Role role);
	
	List<Role> getAllRole();
	
	Role getSingleRoleData(String roleType);
}
