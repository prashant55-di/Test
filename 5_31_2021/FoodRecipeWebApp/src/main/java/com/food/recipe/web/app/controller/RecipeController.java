package com.food.recipe.web.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.food.recipe.web.app.entities.Recipes;
import com.food.recipe.web.app.exceptionHandler.RecipeNotFoundException;
import com.food.recipe.web.app.service.RecipeService;
import com.food.recipe.web.app.service.RecipeServiceImpl;

@RestController
public class RecipeController {

	@Autowired
	private RecipeService recipeService;
	
		//get all the recipes 
		@GetMapping("/recipes")
		public List<Recipes>getRecipes()
		{
			return this.recipeService.getRecipes();
		}
		
		// get the recipe by id
		@GetMapping("/recipes/{recipeId}")
		public Optional<Recipes> getRecipe(@PathVariable String recipeId) throws NumberFormatException, RecipeNotFoundException 
		{
			return this.recipeService.getRecipe(Long.parseLong(recipeId));
		}
		
		// add new recipe 
		@PostMapping("/recipes")
		public Recipes addRecipe(@RequestBody Recipes recipe)
		{
			return this.recipeService.addRecipe(recipe);
		}
		
		// update the existing recipe
		@PutMapping("/recipes")
		public Recipes updateRecipe(@RequestBody Recipes recipe)
		{
			return this.recipeService.updateRecipe(recipe);
		}
		
		//Delete the recipe 
		@DeleteMapping("/recipes/{recipeId}")
		public ResponseEntity<HttpStatus> deleteRecipe(@PathVariable String recipeId)
		{
			try {
				this.recipeService.deleteRecipe(Long.parseLong(recipeId));
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (Exception e)
			{
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
}
