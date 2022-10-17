package com.example.demo.service;

import com.example.demo.model.FlatData;
import com.example.demo.model.Society;

public interface SocietyService {

	void addSocietyData(Society society);
	
	void addFlats(FlatData flatData,String sname);
}
