package com.example.gourmet_map.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "gourmet_map2")
@IdClass(value = GourmetMap3.class)
public class GourmetMap2 {

	@Id
	@Column(name = "diner_name")
	public String dinerName;
	
	@Id
	@Column(name = "dish")
	public String  dish;
	
	@Column(name = "price")
	public int price;
	
	@Column(name = "dish_score")
	public int dishScore;
	

	public GourmetMap2() {
		
	}

	
	public GourmetMap2(String dinerName, String dish, int price, int dishScore) {
		super();
		this.dinerName = dinerName;
		this.dish = dish;
		this.price = price;
		this.dishScore = dishScore;
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
	
	
	
	
	
}
