package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@Entity
@JsonInclude(value = Include.NON_EMPTY)
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lid;

	private String uname;

	private String pass;
	
	private boolean isActive;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Security security;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Admin admin;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Owner owner;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Tenant tenant;
	
}
