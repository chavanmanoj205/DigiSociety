package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4956660079328838707L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	
	private String name;
	
	private String contactNo;
	
	private String email;
	
	private String address;
	
	private String idCardNumber;
	
	@OneToOne(cascade = CascadeType.DETACH)
	private Role role;
	
	}
