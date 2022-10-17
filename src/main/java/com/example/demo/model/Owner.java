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
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "o_f_id")
	private List<FlatData> flist = new ArrayList<FlatData>();
}
