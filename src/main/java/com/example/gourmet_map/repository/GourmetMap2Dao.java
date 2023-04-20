package com.example.gourmet_map.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gourmet_map.entity.GourmetMap2;
import com.example.gourmet_map.entity.GourmetMap3;

public interface GourmetMap2Dao extends JpaRepository<GourmetMap2,GourmetMap3> {
	
	
//  public List<GourmetMap2> findByDinerScoreGreaterThanAndDishScoreGreaterThan(int dinerScore,int dishScore);
//
}
