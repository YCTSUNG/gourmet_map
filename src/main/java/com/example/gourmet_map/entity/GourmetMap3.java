package com.example.gourmet_map.entity;

import java.io.Serializable;
@SuppressWarnings("serial")
public class GourmetMap3 implements Serializable {
	
	private String dinerName;
	
	private String dish;
	
	public GourmetMap3(){
		
	}
	

	public GourmetMap3(String dinerName) {
		super();
		this.dinerName = dinerName;
	}


	public GourmetMap3(String dinerName, String dish) {
		super();
		this.dinerName = dinerName;
		this.dish = dish;
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
}
