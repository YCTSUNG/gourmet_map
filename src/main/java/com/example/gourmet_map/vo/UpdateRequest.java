package com.example.gourmet_map.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateRequest {
	
	@JsonProperty("dinerName")
	public String dinerName;
	
	@JsonProperty("city")
	public String city;
	
	@JsonProperty("newCity")
	public String newCity;
	
	
	@JsonProperty("dinerScore")
	public Integer dinerScore;
	
	
	@JsonProperty("price")
	public Integer price;
	
	@JsonProperty("dish")
	public String dish;
	
	@JsonProperty("dishScore")
	public Integer dishScore;
	
	@JsonProperty("newDinerScore")
	public Integer newDinerScore;
	
	@JsonProperty("newPrice")
	public Integer newPrice;
	
	@JsonProperty("newDishScore")
	public Integer newDishScore;

	public UpdateRequest() {
		super();
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

	public String getNewCity() {
		return newCity;
	}

	public void setNewCity(String newCity) {
		this.newCity = newCity;
	}

	public Integer getDinerScore() {
		return dinerScore;
	}

	public void setDinerScore(Integer dinerScore) {
		this.dinerScore = dinerScore;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getDish() {
		return dish;
	}

	public void setDish(String dish) {
		this.dish = dish;
	}

	public Integer getDishScore() {
		return dishScore;
	}

	public void setDishScore(Integer dishScore) {
		this.dishScore = dishScore;
	}

	public Integer getNewDinerScore() {
		return newDinerScore;
	}

	public void setNewDinerScore(Integer newDinerScore) {
		this.newDinerScore = newDinerScore;
	}

	public Integer getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(Integer newPrice) {
		this.newPrice = newPrice;
	}

	public Integer getNewDishScore() {
		return newDishScore;
	}

	public void setNewDishScore(Integer newDishScore) {
		this.newDishScore = newDishScore;
	}


	
	

}
