package com.example.gourmet_map.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gourmet_map")
public class GourmetMap  {
	
	@Id
	@Column(name = "diner_name")
	public String dinerName;
	
	
	@Column(name = "city")
	public String city;
	
	@Column(name = "diner_score")
	public int dinerScore;
	
	public GourmetMap() {
		
	}
	
	

	public GourmetMap(String dinerName, String city, int dinerScore) {
		super();
		this.dinerName = dinerName;
		this.city = city;
		this.dinerScore = dinerScore;
	}




	public String getDinerName() {
		return dinerName;
	}

	public void setDinerName(String dinerName) {
		this.dinerName = dinerName;
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
