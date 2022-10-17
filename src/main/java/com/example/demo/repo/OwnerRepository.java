package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer>{

	Owner findByOname(String oname);
}
