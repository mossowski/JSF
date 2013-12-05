package com.example.jsfdemo.domain;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class Sandwich {
	
	private String name = "";
	private String id = "";
	private int amount;
	private Date productionDate;
	private double price;
	private boolean vegetarian;
	private String breadColor;
	
	@Size(min = 3, max = 25)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Min(1) @Max(250)
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Past @NotNull
	public Date getProductionDate() {
		return productionDate;
	}
	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}
	
	@Min(1) @Max(10) 
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean getVegetarian() {
		return vegetarian;
	}
	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}
	
	@NotNull
	public String getBreadColor() {
		return breadColor;
	}
	public void setBreadColor(String breadColor) {
		this.breadColor = breadColor;
	}
}
