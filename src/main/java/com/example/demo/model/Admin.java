package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	
	private String aname;

	private String address;

	private String contactNo;

	private String emailId;

	private long aadharNo;

	private String panNo;

	@OneToOne(cascade = CascadeType.DETACH)
	private Role role;
}
