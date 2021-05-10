package com.java.recipe.guid.crudoperations.controller;

   import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
	import org.springframework.validation.annotation.Validated;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import com.java.recipe.guid.crudoperations.exception.RecipeNotFoundException;
	import com.java.recipe.guid.crudoperations.model.RecipeEntity;
	import com.java.recipe.guid.crudoperations.service.RecipeService;

	@RestController
		@RequestMapping("/api/recp1")
	public class RecpController {
		
			@Autowired(required=true)
			private RecipeService recipeService;
			
			
					//Create recipe
					@PostMapping("/recipees")
					public RecipeEntity CreateRecipe(@Validated @RequestBody RecipeEntity recipeEnity){
						return recipeService.createRecipe(recipeEnity);
					}
					
					
					
					@GetMapping("/recipees")
					public List<RecipeEntity> getAllRecipes(){

						return recipeService.getAllRecipes();
					}
					
					
					
					@GetMapping("/recipees/{id}")
					public Object getRecipeEntityById(@PathVariable(value="id")long recipeid) throws RecipeNotFoundException 
					{

					return recipeService.getById(recipeid);

					
					}
					
					
					
					//recipes deletion by id
				    @DeleteMapping("/recipes/{id}")
				    public ResponseEntity<Void> deleteRecipe(@PathVariable(value="id")long recipeid) throws RecipeNotFoundException{
				    	
				    	return recipeService.deleteById(recipeid);
				    	
				    	
				    }
				    
				    @PutMapping("/recipess/{id}")
					public ResponseEntity<HttpStatus> updateRecipe(@PathVariable(value="id")long recipeid
							,@RequestBody RecipeEntity recipeEnityDetails) throws RecipeNotFoundException
					{
											
						return recipeService.updateRecipe(recipeid, recipeEnityDetails).ok(HttpStatus.ACCEPTED);
						//return ResponseEntity.ok().body(recipeEnity);
					}
				    
				    
				    
				    
					
	/*

			
			

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
				//recipeEnity.setTime(recipeEnityDetails.getTime());
				
				recipeRepository.save(recipeEnity);
				return ResponseEntity.ok().body(recipeEnity);
			}
			
		    */

		}



