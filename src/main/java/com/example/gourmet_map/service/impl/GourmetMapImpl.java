package com.example.gourmet_map.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.gourmet_map.entity.GourmetMap;
import com.example.gourmet_map.entity.GourmetMap2;
import com.example.gourmet_map.entity.GourmetMap3;
import com.example.gourmet_map.repository.GourmetMap2Dao;
import com.example.gourmet_map.repository.GourmetMapDao;
import com.example.gourmet_map.service.ifs.GourmetMapService;
import com.example.gourmet_map.vo.GourmetMapRequest;
import com.example.gourmet_map.vo.GourmetMapResponse;
import com.example.gourmet_map.vo.UpdateRequest;

@Service
public class GourmetMapImpl implements GourmetMapService {
	
	@Autowired
	private GourmetMapDao gourmetMapDao;

	@Override
	public GourmetMapResponse addDiner(GourmetMapRequest gourmetMapRequest) {
		List<GourmetMap> errorGourmetMap = new ArrayList<>();
		List<GourmetMap> gourmetMapList = gourmetMapRequest.getGourmetMapList();
		
		for(GourmetMap item : gourmetMapList ) {
		if(!StringUtils.hasText(item.getDinerName()) || item.getDinerScore() < 1 || item.getDinerScore() >5) {
			return new GourmetMapResponse("add Diner error");
		}
			if(gourmetMapDao.existsById(item.getDinerName())) {
				errorGourmetMap.add(item);
			}
		}
		if(!errorGourmetMap.isEmpty()) {
			return new GourmetMapResponse("此餐廳已存在");
		}
		gourmetMapDao.saveAll(gourmetMapList);
		return new GourmetMapResponse(gourmetMapList,"新增餐廳成功");
	}
	
	@Autowired
	private GourmetMap2Dao gourmetMap2Dao;

	@Override
	public GourmetMapResponse addDinerDish(GourmetMapRequest gourmetMapRequest) {
		List<GourmetMap2> errorGourmetMap2 = new ArrayList<>();
		List<GourmetMap2> gourmetMap2List = gourmetMapRequest.getGourmetMap2List();
		
		
		for(GourmetMap2 item : gourmetMap2List ) {
			if(!StringUtils.hasText(item.getDinerName()) || !StringUtils.hasText(item.getDinerName()) ||
					item.getPrice() <=0 || item.getDishScore() <1 || item.getDishScore() >5) {
				        return new GourmetMapResponse("add DinerDIsh error");
			    }
			//雙主鍵需多一道手續
			GourmetMap3 gourmetMap3 = new GourmetMap3();
			gourmetMap3.setDinerName(item.getDinerName());
			gourmetMap3.setDish(item.getDish());
			
			if(gourmetMap2Dao.existsById(gourmetMap3)) {
				errorGourmetMap2.add(item);
			}
		}
		if(!errorGourmetMap2.isEmpty()) {
			return new GourmetMapResponse("此餐廳餐點已存在");
			}
		gourmetMap2Dao.saveAll(gourmetMap2List);
		return new GourmetMapResponse("新增餐廳餐點成功",gourmetMap2List);
	}

	@Override
	public GourmetMapResponse update(UpdateRequest updateRequest) {
			String reqDinerName =  updateRequest.getDinerName();
			String reqDish = updateRequest.getDish();
			String reqNewCity = updateRequest.getNewCity();
			Integer reqNewDinerScore = updateRequest.getNewDinerScore();
			Integer reqNewPrice = updateRequest.getNewPrice();
			Integer reqNewDishScore = updateRequest.getNewDishScore();
			
			
			if(!StringUtils.hasText(reqDinerName)){
			       	 return new GourmetMapResponse("餐廳名不得為空");
			        }
			
			
			if(!StringUtils.hasText(reqNewCity)){
		       	 return new GourmetMapResponse("新城市不得為空");
		        }
			
			
			if(reqNewDinerScore!=null) {
				
			if(reqNewDinerScore < 1 || reqNewDinerScore >5) {
				return new GourmetMapResponse("新餐廳分數必須為1~5");
			}
			
			
			if(reqNewPrice < 1){
				return new GourmetMapResponse("新餐點價格不得小於零");
			}
			
			if(reqNewDishScore < 1 || reqNewDishScore>5) {
				return new GourmetMapResponse("新餐點分數必須為1~5");
			}
			}
			
			 Optional<GourmetMap> op = gourmetMapDao.findById(reqDinerName);
		     if(!op.isPresent()) { //判斷 Optional 中的Bank物件是否存在(包含有判斷 Bank 是否為 null)
		    	  return new GourmetMapResponse("此餐廳不存在");
		     }
		     GourmetMap gourmetMap = op.get();
		 
		     gourmetMap.setCity(reqNewCity);
		     gourmetMap.setDinerScore(reqNewDinerScore);
		     
		     gourmetMapDao.save(gourmetMap);
		
		     GourmetMap3 gourmetMap3 = new GourmetMap3();
		     gourmetMap3.getDinerName();
		     gourmetMap3.getDish();
		     Optional<GourmetMap2> op2 = gourmetMap2Dao.findById(gourmetMap3);
		     if(!op2.isPresent()) {
		    	 return new GourmetMapResponse("此餐點不存在");
		     }
		     GourmetMap2 gourmetMap2 = op2.get();
		     
		     gourmetMap2.setPrice(reqNewPrice);
		     gourmetMap2.setDishScore(reqNewDishScore);
		     
		     gourmetMap2Dao.save(gourmetMap2);
		     
		     
		     
		return new GourmetMapResponse("修改成功");
	}

	@Override
	public List<GourmetMap> findByCity(String city) {
		
		return gourmetMapDao.findByCity(city);
	
	}

	@Override
	public List<GourmetMap> findByDinerScoreGreaterThanDesc(int dinerScore) {
		
		return gourmetMapDao.findByDinerScoreGreaterThanDesc(dinerScore);
	}

	@Override
	public List<GourmetMap2> findByDinerScoreGreaterThanAndDishScoreGreaterThan(int dinerScore, int dishScore) {
		return null;
//		return gourmetMap2Dao.findByDinerScoreGreaterThanAndDishScoreGreaterThan(dinerScore, dishScore);
	}

	   
		
	
	
	
	}	
	
	