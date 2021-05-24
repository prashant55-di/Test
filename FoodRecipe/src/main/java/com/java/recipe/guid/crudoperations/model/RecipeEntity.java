package com.java.recipe.guid.crudoperations.model;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="recipees")


	public class RecipeEntity {
	  
		@Id
		@GeneratedValue
		private int id;
		
		@Column(name="recipe_Name")
		private String recipeName;
		
		@Column(name="recipe_ingrediants")
		
		private String ingrediants;
		
		@Column(name="recipe_steps")
		private String steps;
		
		@OneToMany(targetEntity=RecipeIngrediants.class,cascade=CascadeType.ALL)
		@JoinColumn(name="id",referencedColumnName ="id")
		private List<RecipeIngrediants> recipeIngrediants;
		
		public RecipeEntity() {
			super();
		}
		
		public long getId() {
			return id;
		}
		public void setId(int id) {
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
		
		public RecipeEntity(int id, String recipeName, String ingrediants, String steps) {
			super();
			this.id = id;
			this.recipeName = recipeName;
			this.ingrediants = ingrediants;
			this.steps = steps;
	
		}
		
	}

