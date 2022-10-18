package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
@Entity
public class QRCode implements Serializable{

	private static final long serialVersionUID = 689690908031538386L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	@Enumerated(EnumType.STRING)
	private OccuranceEnum occurance;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User guestUser;

	@Column(columnDefinition="text")
	private String encryptedData;
	
	private boolean active;
	
	private long validFrom;
	
	private long validUpto;
	
	@Column(columnDefinition="text")
	private String fileLocation;
	
	
	
}
