package com.example.gourmet_map.service.impl;

import java.util.ArrayList;
import java.util.List;

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
			return new GourmetMapResponse("���\�U�w�s�b");
		}
		gourmetMapDao.saveAll(gourmetMapList);
		return new GourmetMapResponse(gourmetMapList,"�s�W�\�U���\");
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
			//���D��ݦh�@�D����
			GourmetMap3 gourmetMap3 = new GourmetMap3();
			gourmetMap3.setDinerName(item.getDinerName());
			gourmetMap3.setDish(item.getDish());
			
			if(gourmetMap2Dao.existsById(gourmetMap3)) {
				errorGourmetMap2.add(item);
			}
		}
		if(!errorGourmetMap2.isEmpty()) {
			return new GourmetMapResponse("���\�U�\�I�w�s�b");
			}
		gourmetMap2Dao.saveAll(gourmetMap2List);
		return new GourmetMapResponse("�s�W�\�U�\�I���\",gourmetMap2List);
	}

	
	@Override
	public List<GourmetMap> findByCity(String city) {
		
		return gourmetMapDao.findByCity(city);
	
	}

	@Override
	public List<GourmetMap> findByDinerScoreGreaterThanDesc(int dinerScore) {
		
		return gourmetMapDao.findByDinerScoreGreaterThanOrderByDinerScoreDesc(dinerScore);
	
	}

	@Override
	public List<GourmetMap2> findByDinerScoreGreaterThanAndDishScoreGreaterThan(int dinerScore, int dishScore) {
		return null;
//		return gourmetMap2Dao.findByDinerScoreGreaterThanAndDishScoreGreaterThan(dinerScore, dishScore);
	}

	
	@Override
	public GourmetMapResponse deleteDiner(GourmetMapRequest gourmetMapRequest) {
		List<GourmetMap> gourmetMapList = gourmetMapRequest.getGourmetMapList();
		
		for(GourmetMap item : gourmetMapList ) {
			if(!StringUtils.hasText(item.getDinerName())) {
				return new GourmetMapResponse("�\�U�W�٤��o����");
			}
			if(!gourmetMapDao.existsById(item.getDinerName())) {
				return new GourmetMapResponse("�L���\�U");
			}
			 if (gourmetMapDao.existsById(item.getDinerName())){
				 gourmetMapDao.deleteById(item.getDinerName());
				 GourmetMap3 gourmetMap3 = new GourmetMap3();
					gourmetMap3.setDinerName(item.getDinerName());
					
					if(gourmetMap2Dao.existsById(gourmetMap3)) {
						gourmetMap2Dao.deleteById(gourmetMap3);;
					}
			 }
				
		}
		
	   return new GourmetMapResponse(gourmetMapList,"�\�U�R�����\");
	}
	@Override
	public GourmetMapResponse updateDiner(GourmetMapRequest gourmetMapRequest) {
	    List<GourmetMap> errorGourmetMap = new ArrayList<>();
	    List<GourmetMap> gourmetMapList = gourmetMapRequest.getGourmetMapList();
	    
	    for(GourmetMap item : gourmetMapList ) {
	        if(!StringUtils.hasText(item.getDinerName()) || item.getDinerScore() < 1 || item.getDinerScore() >5
	            || !StringUtils.hasText(item.getCity())) {
	            return new GourmetMapResponse("���e���~�ο�J��Ƥ�����,�ЦA���T�{��J���e");
	        }
	        if(!gourmetMapDao.existsById(item.getDinerName())) {
	            errorGourmetMap.add(item);
	        }
	    }
	    if(!errorGourmetMap.isEmpty()) {
	        return new GourmetMapResponse("���\�U���s�b");
	    }
	    for(GourmetMap item : gourmetMapList ) {
	        GourmetMap existingGourmetMap = gourmetMapDao.findById(item.getDinerName()).get();
	        existingGourmetMap.setDinerScore(item.getDinerScore()); // �ק��\�U����
	        existingGourmetMap.setCity(item.getCity()); // �ק��\�U����
	        gourmetMapDao.save(existingGourmetMap);
	    }
	    return new GourmetMapResponse(gourmetMapList,"�ק��\�U���\");
	}

	@Override
	public GourmetMapResponse updateDinerDish(GourmetMapRequest gourmetMapRequest) {
	    List<GourmetMap2> errorGourmetMap2 = new ArrayList<>();
	    List<GourmetMap2> gourmetMap2List = gourmetMapRequest.getGourmetMap2List();

	    for(GourmetMap2 item : gourmetMap2List ) {
	        if(!StringUtils.hasText(item.getDinerName()) || !StringUtils.hasText(item.getDish()) ||
	                item.getPrice() <=0 || item.getDishScore() <1 || item.getDishScore() >5) {
	            return new GourmetMapResponse("���e���~�ο�J��Ƥ�����,�ЦA���T�{��J���e");
	        }
	        //���D��ݦh�@�D����
	        GourmetMap3 gourmetMap3 = new GourmetMap3();
	        gourmetMap3.setDinerName(item.getDinerName());
	        gourmetMap3.setDish(item.getDish());
	        if(!gourmetMap2Dao.existsById(gourmetMap3)) {
	            errorGourmetMap2.add(item);
	        }
	    }
	    if(!errorGourmetMap2.isEmpty()) {
	        return new GourmetMapResponse("���\�U�\�I���s�b");
	    }
	    for(GourmetMap2 item : gourmetMap2List ) {
	        GourmetMap3 gourmetMap3 = new GourmetMap3();
	        gourmetMap3.setDinerName(item.getDinerName());
	        gourmetMap3.setDish(item.getDish());
	        GourmetMap2 existingGourmetMap2 = gourmetMap2Dao.findById(gourmetMap3).get();
	        existingGourmetMap2.setPrice(item.getPrice()); // �ק��\�I����
	        existingGourmetMap2.setDishScore(item.getDishScore()); // �ק��\�I����
	        gourmetMap2Dao.save(existingGourmetMap2);
	    }
	    return new GourmetMapResponse("�ק��\�U�\�I���\");
	}



	
	}	
	
	