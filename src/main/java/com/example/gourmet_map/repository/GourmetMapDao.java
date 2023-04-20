package com.example.gourmet_map.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gourmet_map.entity.GourmetMap;

@Repository
public interface GourmetMapDao extends JpaRepository<GourmetMap,String>{
	
	public List<GourmetMap> findByCity(String city);
	
	public List<GourmetMap> findByDinerScoreGreaterThanDesc(int dinerScore);
	

}
