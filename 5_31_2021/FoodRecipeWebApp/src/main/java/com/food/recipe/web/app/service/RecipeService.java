package com.food.recipe.web.app.service;

import java.util.List;
import java.util.Optional;

import com.food.recipe.web.app.entities.Recipes;
import com.food.recipe.web.app.exceptionHandler.RecipeNotFoundException;

public interface RecipeService {

	public List<Recipes> getRecipes();
	
	public Optional<Recipes> getRecipe(long recipeId);
	
	public Recipes addRecipe(Recipes recipe);
	
	public Recipes updateRecipe(Recipes recipe);
	
	public void deleteRecipe(long recipId);
	
}
