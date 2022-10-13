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
public class Tenant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tid;

	private String tname;

    private String taddress;
	
	private String tcontactNo;
	
	private String temailId;
	
	private long taadharNo;
	
	private String tpanNo;
	
	@OneToOne(cascade = CascadeType.DETACH)
	private Role role;

}
