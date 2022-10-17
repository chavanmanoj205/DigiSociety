package com.example.demo.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.QRCodeDTO;

public interface ScannerService {

	
	public String createScanner(@RequestBody QRCodeDTO login);
	
}
