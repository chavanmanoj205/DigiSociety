package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5536718712778944471L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rid;
	
	@Enumerated(EnumType.STRING)
	private RoleEnum roleType;
	
	
}
