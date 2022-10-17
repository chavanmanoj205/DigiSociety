package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.QRCode;

public interface ScannerRepository extends JpaRepository<QRCode, Integer>{

}
