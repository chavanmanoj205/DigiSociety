package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{

	Login findByUnameAndPass(String uname,String pass);
	
	Login findByUname(String uname);
}
