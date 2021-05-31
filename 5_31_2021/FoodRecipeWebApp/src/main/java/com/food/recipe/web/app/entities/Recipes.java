package com.food.recipe.web.app.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Recipes {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="recipeName")
	private String recipename;
	
	private boolean vegetarian = true;
	
	@Column(name="timestamp")
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date created;
	
	@Column(name="recipeSteps")
	private String recipe_steps;
	
	@OneToMany(cascade=CascadeType.ALL ,fetch = FetchType.LAZY)
	@JoinColumn
	private List<RecipeIngrediants> recipeIngrediants;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRecipename() {
		return recipename;
	}

	public void setRecipename(String recipename) {
		this.recipename = recipename;
	}

	public String getRecipe_steps() {
		return recipe_steps;
	}

	public void setRecipe_steps(String recipe_steps) {
		this.recipe_steps = recipe_steps;
	}

	public Recipes() {
		super();
	}
	
	public Recipes(long id, String recipename, boolean vegetarian, Date created, String recipe_steps,
			List<RecipeIngrediants> recipeIngrediants) {
		super();
		this.id = id;
		this.recipename = recipename;
		this.vegetarian = vegetarian;
		this.created = created;
		this.recipe_steps = recipe_steps;
		this.recipeIngrediants = recipeIngrediants;
	}

	@Override
	public String toString() {
		return "Recipes [id=" + id + ", recipename=" + recipename + ", vegetarian=" + vegetarian + ", created="
				+ created + ", recipe_steps=" + recipe_steps + ", recipeIngrediants=" + recipeIngrediants + "]";
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	
}
