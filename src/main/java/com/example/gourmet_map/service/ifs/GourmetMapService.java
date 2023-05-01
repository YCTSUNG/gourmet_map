package com.example.gourmet_map.service.ifs;

import java.util.List;

import com.example.gourmet_map.entity.GourmetMap;
import com.example.gourmet_map.entity.GourmetMap2;
import com.example.gourmet_map.vo.GourmetMapRequest;
import com.example.gourmet_map.vo.GourmetMapResponse;
import com.example.gourmet_map.vo.UpdateRequest;

public interface GourmetMapService {
	
	public GourmetMapResponse addDiner(GourmetMapRequest gourmetMapRequest);
	
	public GourmetMapResponse deleteDiner(GourmetMapRequest gourmetMapRequest);
	
	public GourmetMapResponse updateDiner(GourmetMapRequest gourmetMapRequest);
	
	
	public GourmetMapResponse addDinerDish(GourmetMapRequest gourmetMapRequest);
	
	public GourmetMapResponse updateDinerDish(GourmetMapRequest gourmetMapRequest);
	
	
	public List<GourmetMap> findByCity(String city);
	
	public List<GourmetMap> findByDinerScoreGreaterThanDesc(int dinerScore);
	
	public List<GourmetMap2> findByDinerScoreGreaterThanAndDishScoreGreaterThan(int dinerScore,int dishScore);
	
	
	

}
