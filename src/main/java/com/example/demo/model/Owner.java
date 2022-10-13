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
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int oid;

	private String oname;

    private String oaddress;
	
	private String ocontactNo;
	
	private String oemailId;
	
	private long oaadharNo;
	
	private String opanNo;

	@OneToOne(cascade = CascadeType.DETACH)
	private Role role;
}
