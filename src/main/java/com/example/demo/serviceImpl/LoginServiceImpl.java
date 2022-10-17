package com.example.demo.serviceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.constants.Constant;
import com.example.demo.exception.ResouceNotFoundException;
import com.example.demo.model.Login;
import com.example.demo.repo.LoginRepository;
import com.example.demo.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	private static final Logger LOGGER = LogManager.getLogger(LoginServiceImpl.class); 
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public void addInsertData(Login login) {
		// TODO Auto-generated method stub
		LOGGER.info("Login Data In Login Service : " + login);
		login.setActive(Constant.FLAG);
		loginRepository.save(login);
		LOGGER.info("Logi Data Inserted...!");
	}

	@Override
	public Login getLoginData(String uname, String pass) throws ResouceNotFoundException {
		// TODO Auto-generated method stub
		LOGGER.info("Login Credentials : " +  uname + " " + pass);
		Login login = loginRepository.findByUnameAndPass(uname, pass);
		LOGGER.debug("Login Data Before : " + login);
		if(login != null) {
			if(login.isActive()) {
			LOGGER.debug("Login Data In If : " + login);
			return login;
			}
			else {
				LOGGER.error("Pls Contact Your Admin...!");
				throw new ResouceNotFoundException("Pls Contact Your Admin...!");
			}
		}else{
			LOGGER.error("Invalid Username and Password...!");
			throw new ResouceNotFoundException("Invalid Username and Password...!");
		}
		
	}

	@Override
	public void addDiffernetUser(Login login) {
		// TODO Auto-generated method stub
		LOGGER.info("Different user Data In Login Service : " + login);
		login.setActive(Constant.FLAG1);
		LOGGER.info("Check Data : " + login);
		loginRepository.save(login);
		LOGGER.info("User Data Inserted...!");
	}

}
