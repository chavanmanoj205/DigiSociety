package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentData {

	private String documentName;
	
    private String documentPath;
}
