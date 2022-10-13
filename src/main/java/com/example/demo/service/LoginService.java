package com.example.demo.service;

import com.example.demo.exception.ResouceNotFoundException;
import com.example.demo.model.Login;

public interface LoginService {

	void addInsertData(Login login);
	
	void addDiffernetUser(Login login);
	
	Login getLoginData(String uname,String pass)throws ResouceNotFoundException;
}
