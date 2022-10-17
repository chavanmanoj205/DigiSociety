package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FlatData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fid;
	
	private String fname;
	
	private String ftype;
	
	private String buildingNo;
	
	private String flatFloor;
	
	private int flatNo;

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFtype() {
		return ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	public String getBuildingNo() {
		return buildingNo;
	}

	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}

	public String getFlatFloor() {
		return flatFloor;
	}

	public void setFlatFloor(String flatFloor) {
		this.flatFloor = flatFloor;
	}

	public int getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(int flatNo) {
		this.flatNo = flatNo;
	}

	@Override
	public String toString() {
		return "FlatData [fid=" + fid + ", fname=" + fname + ", ftype=" + ftype + ", buildingNo=" + buildingNo
				+ ", flatFloor=" + flatFloor + ", flatNo=" + flatNo + "]";
	}
	
	
}
