package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.DocumentData;

public interface DocumentService {

	DocumentData uploadDocuments(MultipartFile file);
}
