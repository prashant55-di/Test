package com.java.recipe.guid.crudoperations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.recipe.guid.crudoperations.exception.RecipeNotFoundException;
import com.java.recipe.guid.crudoperations.model.RecipeEntity;
import com.java.recipe.guid.crudoperations.model.RecipeIngrediants;
import com.java.recipe.guid.crudoperations.repository.RecipeRepository;

@Service
//@RequestMapping("/api/recp1")
public class RecipeService {

	@Autowired
	private RecipeRepository recipeRepository;
	
	@Autowired
	private RecipeIngrediants recipeIngrediants;
	
	
	public RecipeEntity createRecipe(RecipeEntity recipeEnity) {
		return recipeRepository.save(recipeEnity);
	}
	
	
	public List<RecipeEntity> getAllRecipes() {
		return recipeRepository.findAll();
	}
	

	
	public ResponseEntity<RecipeEntity> getById(int recipeid) throws RecipeNotFoundException {
		RecipeEntity recipeEnity=recipeRepository.findById(recipeid).orElseThrow(()-> new RecipeNotFoundException("Recipe unavailable for this id ::" + recipeid) );
		return new ResponseEntity<>(recipeEnity,HttpStatus.OK);
	}
	
	public ResponseEntity<Void> deleteById(int recipeid) throws RecipeNotFoundException {

		recipeRepository.findById(recipeid).orElseThrow(()-> 
    	new RecipeNotFoundException("Recipe unavailable for this id ::" + recipeid) );
    	
    	recipeRepository.deleteById(recipeid);
    	return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	public RecipeEntity updateRecipe(RecipeEntity recipeEnity) {
		return recipeRepository.save(recipeEnity);
	}
	
/*	public ResponseEntity<RecipeEntity> updateRecipe(@PathVariable(value="id")long recipeid
			,@RequestBody RecipeEntity recipeEnityDetails) throws RecipeNotFoundException
	{
		RecipeEntity recipeEnity=recipeRepository.findById(recipeid).orElseThrow(()-> new RecipeNotFoundException("Recipe unavailable for this id ::" + recipeid) );
		
		recipeEnity.setIngrediants(recipeEnityDetails.getIngrediants());
		recipeEnity.setRecipeName(recipeEnityDetails.getRecipeName());
		recipeEnity.setSteps(recipeEnityDetails.getSteps());
		recipeEnity.setId(recipeEnityDetails.getId());
				
		recipeRepository.save(recipeEnity);
		return ResponseEntity.ok().body(recipeEnity);
	}
*/

}
	
	/*
	//Create get all recipes details
	@GetMapping("/recipees")
	public List<RecipeEntity> findAll() {
		return recipeRepository.findAll();
	}
	
	@PostMapping("/recipees")
	public RecipeEntity save(@Validated @RequestBody RecipeEntity recipeEnity) {
		return recipeRepository.save(recipeEnity);
	}
	
	
	//recipes get by id
	@GetMapping("/recipees/{id}")
	
	public ResponseEntity <RecipeEntity> findById(@PathVariable(value="id")long recipeid) throws RecipeNotFoundException {
		
		RecipeEntity recipeEnity=recipeRepository.findById(recipeid).orElseThrow(()-> new RecipeNotFoundException("Recipe unavailable for this id ::" + recipeid) );
		
		return ResponseEntity.ok().body(recipeEnity);
	}
			
			// recipes update
			
			@PutMapping("/recipess/{id}")
			public ResponseEntity<RecipeEntity> updateRecipe(@PathVariable(value="id")long recipeid
					,@RequestBody RecipeEntity recipeEnityDetails) throws RecipeNotFoundException
			{
				RecipeEntity recipeEnity=recipeRepository.findById(recipeid).orElseThrow(()-> new RecipeNotFoundException("Recipe unavailable for this id ::" + recipeid) );
				
				recipeEnity.setIngrediants(recipeEnityDetails.getIngrediants());
				recipeEnity.setRecipeName(recipeEnityDetails.getRecipeName());
				recipeEnity.setSteps(recipeEnityDetails.getSteps());
				recipeEnity.setId(recipeEnityDetails.getId());
				
				//(recipeEnityDetails.getTime());
				
				recipeRepository.save(recipeEnity);
				return ResponseEntity.ok().body(recipeEnity);
			}
			//recipes deletion by id
		    @DeleteMapping("/recipes/{id}")
		    public ResponseEntity<Void> deleteRecipe(@PathVariable(value="id")long recipeid) throws RecipeNotFoundException{
		    	recipeRepository.findById(recipeid).orElseThrow(()-> 
		    	new RecipeNotFoundException("Recipe unavailable for this id ::" + recipeid) );
		    	
		    	recipeRepository.deleteById(recipeid);
		    	return new ResponseEntity<Void>(HttpStatus.OK);
		    }
	
}*/