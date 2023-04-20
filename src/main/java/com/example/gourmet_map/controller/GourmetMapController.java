package com.example.gourmet_map.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.gourmet_map.entity.GourmetMap;
import com.example.gourmet_map.entity.GourmetMap2;
import com.example.gourmet_map.service.ifs.GourmetMapService;
import com.example.gourmet_map.vo.GourmetMapRequest;
import com.example.gourmet_map.vo.GourmetMapResponse;
import com.example.gourmet_map.vo.UpdateRequest;

@RestController
public class GourmetMapController {

	@Autowired
	GourmetMapService gourmetMapService;
	
	@PostMapping("add_diner")
	public GourmetMapResponse addDiner(@RequestBody GourmetMapRequest gourmetMapRequest) {
		return gourmetMapService.addDiner(gourmetMapRequest);
	}
	
	@PostMapping("add_dinerdish")
	public GourmetMapResponse addDinerDish(@RequestBody GourmetMapRequest gourmetMapRequest) {
		
		return gourmetMapService.addDinerDish(gourmetMapRequest);
	}
	
	@PostMapping("update")
	public GourmetMapResponse update(@RequestBody UpdateRequest updateRequest) {
		return gourmetMapService.update(updateRequest);
	}
	
	@PostMapping("find_by_city")
    public List<GourmetMap> findByCity(@RequestBody GourmetMapRequest gourmetMapRequest ){
		return gourmetMapService.findByCity(gourmetMapRequest.getCity());
	}
	
	@PostMapping("find_by_dinerscore_greater_than_desc")
	public List<GourmetMap> findByDinerScoreGreaterThanDesc(@RequestBody GourmetMapRequest gourmetMapRequest){
		return gourmetMapService.findByDinerScoreGreaterThanDesc(gourmetMapRequest.getDinerScore());
	}
	
	@PostMapping("find_by_dinerscore_greater_than_and_dishscore_greater_than")
	public List<GourmetMap2> findByDinerScoreGreaterThanAndDishScoreGreaterThan(@RequestBody GourmetMapRequest gourmetMapRequest){
		return gourmetMapService.findByDinerScoreGreaterThanAndDishScoreGreaterThan(gourmetMapRequest.getDinerScore(),gourmetMapRequest.getDishScore() );
	}
	
	
}
