package com.example.demo.serviceImpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Role;
import com.example.demo.repo.RoleRepository;
import com.example.demo.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	private static final Logger LOGGER = LogManager.getLogger(RoleServiceImpl.class); 
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public void addRoleData(Role role) {
		// TODO Auto-generated method stub
		LOGGER.info("Role Inserting........!");
		roleRepository.save(role);
		LOGGER.info("Role Inserted........!");

	}

	@Override
	public List<Role> getAllRole() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public Role getSingleRoleData(String roleType) {
		// TODO Auto-generated method stub
	     Role role = roleRepository.findByRoleType(roleType);
		return role;
	}

}
