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


@Entity
public class Society {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int soid;
	
	private String societyName;
	
	private String societyAddress;
	
	private String societyEmailId;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "so_f_id")
	private List<FlatData> flist = new ArrayList<FlatData>();

	public List<FlatData> getFlist() {
		return flist;
	}

	public void setFlist(List<FlatData> flist) {
		this.flist = flist;
	}

	public int getSoid() {
		return soid;
	}

	public void setSoid(int soid) {
		this.soid = soid;
	}

	public String getSocietyName() {
		return societyName;
	}

	public void setSocietyName(String societyName) {
		this.societyName = societyName;
	}

	public String getSocietyAddress() {
		return societyAddress;
	}

	public void setSocietyAddress(String societyAddress) {
		this.societyAddress = societyAddress;
	}

	public String getSocietyEmailId() {
		return societyEmailId;
	}

	public void setSocietyEmailId(String societyEmailId) {
		this.societyEmailId = societyEmailId;
	}

	@Override
	public String toString() {
		return "Society [soid=" + soid + ", societyName=" + societyName + ", societyAddress=" + societyAddress
				+ ", societyEmailId=" + societyEmailId + ", flist=" + flist + "]";
	}
	
	
}
