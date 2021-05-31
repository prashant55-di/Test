package com.food.recipe.web.app.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class RecipeIngrediants {

	@Id
	@JsonIgnore
	@GeneratedValue(strategy=GenerationType.AUTO)    
	private Long id;
	
	private int qty;
	
	private String Ingrediants_name;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getIngrediants_name() {  
	    return Ingrediants_name;  
	}  
	  
	public void setIngrediants_name(String Ingrediants_name) {  
	    this.Ingrediants_name = Ingrediants_name;  
	}     
	  
	public RecipeIngrediants(Long id, int qty, String ingrediants_name) {
		super();
		this.id = id;
		this.qty = qty;
		Ingrediants_name = ingrediants_name;
	}
	
	public RecipeIngrediants() {  
	    super();  
	}

	@Override
	public String toString() {
		return "RecipeIngrediants [id=" + id + ", qty=" + qty + ", Ingrediants_name=" + Ingrediants_name + "]";
	}    
	      
	}  

