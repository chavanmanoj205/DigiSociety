package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FlatData;
import com.example.demo.model.Society;
import com.example.demo.repo.SocietyRepository;
import com.example.demo.service.SocietyService;

@Service
public class SocietyServiceImpl implements SocietyService{

	@Autowired
	private SocietyRepository societyRepository;
	
	@Override
	public void addSocietyData(Society society) {
		// TODO Auto-generated method stub
	   societyRepository.save(society);	
	}

	@Override
	public void addFlats(FlatData flatData, String sname) {
		// TODO Auto-generated method stub
		Society society = societyRepository.findBySocietyName(sname);
		if(society != null) {
			society.getFlist().add(flatData);
			societyRepository.save(society);
		}
	}

}
