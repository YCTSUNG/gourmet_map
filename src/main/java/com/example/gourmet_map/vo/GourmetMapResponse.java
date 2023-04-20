package com.example.gourmet_map.vo;

import java.util.List;

import com.example.gourmet_map.entity.GourmetMap;
import com.example.gourmet_map.entity.GourmetMap2;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GourmetMapResponse {
	
	@JsonProperty("gourmet_map")
	private GourmetMap gourmetMap;
	
	@JsonProperty("gourmet_map_list")
	private List<GourmetMap> gourmetMapList;
	
	@JsonProperty("gourmet_map2")
	private GourmetMap2 gourmetMap2;
	
	@JsonProperty("gourmet_map2_list")
	private List<GourmetMap2> gourmetMap2List;
	
	
	public String message;
	
	public GourmetMapResponse() {
		
	}
	

	public GourmetMapResponse(List<GourmetMap> gourmetMapList, String message) {
		super();
		this.gourmetMapList = gourmetMapList;
		this.message = message;
	}
	
	
	
	public GourmetMapResponse(String message, List<GourmetMap2> gourmetMap2List) {
		super();
		this.gourmetMap2List = gourmetMap2List;
		this.message = message;
	}


	public GourmetMapResponse(GourmetMap gourmetMap, String message) {
		super();
		this.gourmetMap = gourmetMap;
		this.message = message;
	}
	
	
	
	
	public GourmetMapResponse(GourmetMap2 gourmetMap2, String message) {
		super();
		this.gourmetMap2 = gourmetMap2;
		this.message = message;
	}


	public GourmetMapResponse(String message) {
		super();
		this.message = message;
	}
	
	
	public GourmetMapResponse(GourmetMap gourmetMap) {
		super();
		this.gourmetMap = gourmetMap;
	}
	
	

	public GourmetMapResponse(GourmetMap2 gourmetMap2) {
		super();
		this.gourmetMap2 = gourmetMap2;
	}


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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
	
	
	
	
	

}
