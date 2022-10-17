package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "a_o_id")
	private List<Owner> olist = new ArrayList<Owner>();
	
	
}
