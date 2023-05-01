package com.example.gourmet_map.vo;

import java.util.List;

import com.example.gourmet_map.entity.GourmetMap;
import com.example.gourmet_map.entity.GourmetMap2;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GourmetMapRequest {
	
	@JsonProperty("gourmet_map")
	private GourmetMap gourmetMap;
	
	@JsonProperty("gourmet_map_list")
	private List<GourmetMap> gourmetMapList;
	
	@JsonProperty("gourmet_map2")
	private GourmetMap2 gourmetMap2;
	
	@JsonProperty("gourmet_map2_list")
	private List<GourmetMap2> gourmetMap2List;
	
	public String dinerName;
	
	public String dish;
	
	public String city;
	
	public int dinerScore;
	
	public int price;
	
	public int dishScore;
	
	

	public GourmetMap getGourmetMap() {
		return gourmetMap;
	}

	public void setGourmetMap(GourmetMap gourmetMap) {
		this.gourmetMap = gourmetMap;
	}

	public List<GourmetMap> getGourmetMapList() {
		return gourmetMapList;
	}

	public void setGourmetMapList(List<GourmetMap> gourmetMapList) {
		this.gourmetMapList = gourmetMapList;
	}

	public GourmetMap2 getGourmetMap2() {
		return gourmetMap2;
	}

	public void setGourmetMap2(GourmetMap2 gourmetMap2) {
		this.gourmetMap2 = gourmetMap2;
	}

	public List<GourmetMap2> getGourmetMap2List() {
		return gourmetMap2List;
	}

	public void setGourmetMap2List(List<GourmetMap2> gourmetMap2List) {
		this.gourmetMap2List = gourmetMap2List;
	}

	public String getDinerName() {
		return dinerName;
	}

	public void setDinerName(String dinerName) {
		this.dinerName = dinerName;
	}

	public String getDish() {
		return dish;
	}

	public void setDish(String dish) {
		this.dish = dish;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDishScore() {
		return dishScore;
	}

	public void setDishScore(int dishScore) {
		this.dishScore = dishScore;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getDinerScore() {
		return dinerScore;
	}

	public void setDinerScore(int dinerScore) {
		this.dinerScore = dinerScore;
	}


	
	
	

}
