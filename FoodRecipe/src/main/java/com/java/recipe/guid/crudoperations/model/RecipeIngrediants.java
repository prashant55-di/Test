package com.java.recipe.guid.crudoperations.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RecipeIngrediants {
	
	@Id
	private int Iid;
	
	
	public int getIid() {
		return Iid;
	}

	public void setIid(int iid) {
		Iid = iid;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	private int qty;
	private int price;
	
    @GeneratedValue(strategy=GenerationType.AUTO)    
	private String Ingrediants_name;  
	  
	public RecipeIngrediants( String Ingrediants_name) {  
	    super();   
	    this.Ingrediants_name = Ingrediants_name;  
	      
	}  
	  
	public RecipeIngrediants() {  
	    super();  
	}   
	public String getIngrediants_name() {  
	    return Ingrediants_name;  
	}  
	  
	public void setIngrediants_name(String Ingrediants_name) {  
	    this.Ingrediants_name = Ingrediants_name;  
	}  
	  
	      
	}  

