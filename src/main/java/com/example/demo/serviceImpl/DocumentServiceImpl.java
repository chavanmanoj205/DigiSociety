package com.example.demo.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.exception.DocUploadException;
import com.example.demo.model.DocumentData;
import com.example.demo.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService{

	private Path fileUploadLocation;
	
	 @PostConstruct
	    public void init() {
	        fileUploadLocation = Paths.get("E:\\springLog").toAbsolutePath().normalize();
	        try {
	            Files.createDirectories(this.fileUploadLocation);
	            System.out.println("Base directory created");
	        } catch (Exception ex) {
	        	System.out.println("Directory cannot be created");
	            throw new DocUploadException("Could not create the directory where the uploaded files will be stored.", ex);
	        }
	    }
	
	
	@Override
	public DocumentData uploadDocuments(MultipartFile file) {
		 String filename = file.getOriginalFilename();
	        final String batchFolderLocation = createBatchFolder();
	       // final String packageFolderLocation = createPackageFolder(batchFolderLocation);
	        try {
	            String target = batchFolderLocation + File.separator + filename;
	            saveUploadedFile(file, target);
	            DocumentData response = DocumentData.builder()
	                   // .packageNo(packageFolderLocation.substring(packageFolderLocation.lastIndexOf(File.separator) + 1))
	                    //.batchId(batchFolderLocation.substring(batchFolderLocation.lastIndexOf(File.separator) + 1))
	                    .documentPath(batchFolderLocation).documentName(filename).build();
	            //streamBridge.send(propertiesConfig.getBindingName(), response);
	            return response;
	        } catch (IOException ex) {
	            System.out.println("Error occurred while storing file");
	            throw new DocUploadException("Could not store file " + filename + ". Please try again!", ex);
	        }

	}
	 public String createBatchFolder() {
		    System.out.println("Creating Batch folder");
	        String folderLocation = this.fileUploadLocation + File.separator + "Batch" + getRandomString();
	        Path path = Paths.get(folderLocation);
	        try {
	            Files.createDirectories(path);
	            System.out.println("Batch folder created");
	            return folderLocation;
	        } catch (Exception ex) {
	        	System.out.println("Error occurred while creating Batch folder");
	            throw new DocUploadException("Error occurred while creating Batch folder", ex);
	        }
	    }

	    private String getRandomString() {
	        Random rand = new Random();
	        return String.format("%04d", rand.nextInt(10000));
	    }

//	    public String createPackageFolder(String location) {
//	        System.out.println("Creating Package folder");
//	        String folderLocation = location + File.separator + "Package" + getRandomString();
//	        Path path = Paths.get(folderLocation);
//	        try {
//	            Files.createDirectories(path);
//	            System.out.println("Package directory created");
//	            return folderLocation;
//	        } catch (Exception ex) {
//	        	System.out.println("Error occurred while creating Package folder.");
//	            throw new DocUploadException("Error occurred while creating Package folder.", ex);
//	        }
//	    }

	private void saveUploadedFile(MultipartFile file, final String target) throws IOException {
        byte[] bytes = file.getBytes();
        Path path = Paths.get(target);
        Files.write(path, bytes);
    }
}
