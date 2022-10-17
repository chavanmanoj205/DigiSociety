package com.example.demo.serviceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Admin;
import com.example.demo.model.FlatData;
import com.example.demo.model.Owner;
import com.example.demo.repo.AdminRepository;
import com.example.demo.repo.FlatDataRepository;
import com.example.demo.repo.OwnerRepository;
import com.example.demo.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	private static final Logger LOGGER = LogManager.getLogger(AdminServiceImpl.class);

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	@Autowired
	private FlatDataRepository flatDataRepository;
	
	@Override
	public Owner addflattoOwner(String aname, String oname, String bNo, int fid) {
		// TODO Auto-generated method stub
		Admin admin = adminRepository.findByAname(aname);
		System.out.println("Admin : " + admin);
		Owner owner = ownerRepository.findByOname(oname);
		System.out.println("Owner :  " + owner);
		FlatData flatData = flatDataRepository.findByFlatNoAndBuildingNo(fid, bNo);
		System.out.println(flatData);
		owner.getFlist().add(flatData);
		admin.getOlist().add(owner);
		
		adminRepository.save(admin);
		
		return owner;
	} 

	

}
