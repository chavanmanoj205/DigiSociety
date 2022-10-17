package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.exception.DocUploadException;
import com.example.demo.model.DocumentData;
import com.example.demo.service.DocumentService;

@RestController
public class DocumentController {
	
	@Autowired
	private DocumentService doumentService;
	
	@PostMapping(value = "/documentUpload")
    public ResponseEntity<DocumentData> uploadData(@RequestParam(name = "file") MultipartFile file) {
		System.out.println("Document upload process starts..");
        try {
            DocumentData response = doumentService.uploadDocuments(file);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            System.out.println("Error occurred while saving data");
            throw new DocUploadException("Document Storig is not Uploaded");
        }
	}
}
