package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.FlatData;
import com.example.demo.model.Society;
import com.example.demo.service.SocietyService;

@RestController
public class SocietyController {

	@Autowired
	private SocietyService societyService;
	
	@PostMapping(value = "/addSociety")
	public String addSocietyData(@RequestBody Society society) {
		System.out.println("CheckData : " + society);
		societyService.addSocietyData(society);
		return "Society Added";
	}
	
	@PostMapping(value ="/addFlats")
	public String flatDataAdd(@RequestBody FlatData flatData,@RequestParam String sname) {
		societyService.addFlats(flatData, sname);
		return "FlatData Added";
	}
	
}
