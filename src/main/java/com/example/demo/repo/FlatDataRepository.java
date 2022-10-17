package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.FlatData;

@Repository
public interface FlatDataRepository extends JpaRepository<FlatData, Integer>{

	FlatData findByFlatNoAndBuildingNo(int fid,String bNo);
}
