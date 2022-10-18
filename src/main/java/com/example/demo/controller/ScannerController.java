package com.example.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.ApiEndpoint;
import com.example.demo.dto.QRCodeDTO;
import com.example.demo.service.ScannerService;

@RestController
@RequestMapping("Scanner/")
public class ScannerController {

	private static final Logger LOGGER = LogManager.getLogger(ScannerController.class); 
	
	@Autowired
	private ScannerService service;
	
	@PostMapping(value = ApiEndpoint.INSERT)
	public String createScanner(@RequestBody QRCodeDTO qrCode ){
		LOGGER.info("QR CODE DETAILS : "+qrCode);
		service.createScanner(qrCode);
		LOGGER.info("QR Code created successfully");
		return "success";
	}
	
	
	
}
