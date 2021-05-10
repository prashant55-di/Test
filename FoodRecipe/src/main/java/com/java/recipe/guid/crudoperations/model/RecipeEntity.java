package com.java.recipe.guid.crudoperations.model;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
	@Table(name="recipees")
	public class RecipeEntity {
		
	
	 private static final SimpleDateFormat df = new SimpleDateFormat( "h:mma" );
	  
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long id;
		
		@Column(name="recipe_Name")
		private String recipeName;
		
		@Column(name="recipe_ingrediants")
		private String ingrediants;
		
		@Column(name="recipe_steps")
		private String steps;
		
		//@Column
		//private LocalDateTime dt;
		
		
		
		//private java.sql.Time time;
		
		public RecipeEntity() {
			super();
		}
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getRecipeName() {
			return recipeName;
		}
		public void setRecipeName(String recipeName) {
			this.recipeName = recipeName;
		}
		public String getIngrediants() {
			return ingrediants;
		}
		public void setIngrediants(String ingrediants) {
			this.ingrediants = ingrediants;
		}
		public String getSteps() {
			return steps;
		}
		public void setSteps(String steps) {
			this.steps = steps;
		}
		
		public RecipeEntity(long id, String recipeName, String ingrediants, String steps) {
			super();
			this.id = id;
			this.recipeName = recipeName;
			this.ingrediants = ingrediants;
			this.steps = steps;
	
		}
		
		
	}

