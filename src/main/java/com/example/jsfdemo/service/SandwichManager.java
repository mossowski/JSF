package com.example.jsfdemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.example.jsfdemo.domain.Sandwich;

@ApplicationScoped
public class SandwichManager {
	
	private List<Sandwich> db = new ArrayList<Sandwich>();

	public void addSandwich(Sandwich sandwich) {
		Sandwich newSandwich = new Sandwich();

		newSandwich.setName(sandwich.getName());
		newSandwich.setId(sandwich.getId());
		newSandwich.setAmount(sandwich.getAmount());
		newSandwich.setProductionDate(sandwich.getProductionDate());
		newSandwich.setPrice(sandwich.getPrice());
		newSandwich.setVegetarian(sandwich.getVegetarian());
		newSandwich.setBreadColor(sandwich.getBreadColor());
		
		db.add(newSandwich);
	}

	public void deleteSandwich(Sandwich sandwich) {
		Sandwich sandwichToRemove = null;
		for (Sandwich s : db) {
			if (sandwich.getName().equals(s.getName())) {
				sandwichToRemove = s;
				break;
			}
		}
		if (sandwichToRemove != null)
			db.remove(sandwichToRemove);
	}

	public List<Sandwich> getAllSandwiches() {
		return db;
	}
}