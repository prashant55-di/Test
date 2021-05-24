/*/ *package com.java.recipe.guid.crudoperations.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.recipe.guid.crudoperations.model.RecipeEntity;


public class RecipeEntityTest {

	@RunWith(SpringRunner.class)
	@DataJpaTest
	public class FoodRecipeDaoTest {

	 @Autowired
	private TestEntityManager entityManager;
	 
	@Autowired
	private RecipeEntity recipeEntity;
	
	@Test
	public void testSaveRecipe(){
	RecipeEntity recipeEntity = getId();
	RecipeEntity savedInDb = entityManager.persist(recipeEntity);
	Optional<RecipeEntity> getFromDb = recipeEntity.getById(savedInDb.getId());
	assertThat(getFromDb ,savedInDb);
	}

	 //private void assertThat(Optional<Recipe> getFromDb, Recipe savedInDb) {
	//System.out.println("Both are equal");
	private void assertThat(Optional<Recipe> getFromDb, Recipe savedInDb) {
	System.out.println("equal");
	}

	// }
	private Recipe getRecipe() {
	Recipe recipe = new Recipe();
	recipe.setRecipeName("chicken");
	recipe.setRecipeType("non-veg");
	recipe.setNoOfPeopleSuitable(20);
	return recipe;
	}




	@Test
	public void testGetAllRecipes(){
	Recipe recipe = new Recipe();
	recipe.setRecipeName("chicken");
	recipe.setRecipeType("non-veg");
	recipe.setNoOfPeopleSuitable(20);

	Recipe recipe1 = new Recipe();
	recipe1.setRecipeName("chicken");
	recipe1.setRecipeType("non-veg");
	recipe1.setNoOfPeopleSuitable(20);
	//Save both tickets in DB
	entityManager.persist(recipe);
	entityManager.persist(recipe1);
	Iterable<Recipe> allRecipesFromDb = foodRecipeDao.findAll();
	List<Recipe> recipeList = new ArrayList<>();
	for (Recipe recipe2 : allRecipesFromDb) {
	recipeList.add(recipe2);
	}
	Assertions.assertThat(recipeList.size()).isEqualTo(2);
	}

	@Test
	public void testGetRecipeById(){
	Recipe recipe = new Recipe();
	recipe.setRecipeName("chicken");
	recipe.setRecipeType("non-veg");
	recipe.setNoOfPeopleSuitable(20);
	Recipe savedInDb = entityManager.persist(recipe);
	Optional<Recipe> getFromDb = foodRecipeDao.findById(savedInDb.getRecipeId());
	assertThat(getFromDb ,savedInDb);
	}


	@Test
	public void testDeleteRecipeById(){
	Recipe recipe = new Recipe();
	recipe.setRecipeName("chicken");
	recipe.setRecipeType("non-veg");
	recipe.setNoOfPeopleSuitable(20);

	Recipe recipe1 = new Recipe();
	recipe1.setRecipeName("chicken");
	recipe1.setRecipeType("non-veg");
	recipe1.setNoOfPeopleSuitable(20);
	Recipe savedInDb = entityManager.persist(recipe);
	entityManager.persist(recipe1);
	//delete one field
	entityManager.remove(recipe);
	Iterable<Recipe> allRecipesFromDb = foodRecipeDao.findAll();
	List<Recipe> recipeList = new ArrayList<>();
	for (Recipe recipe3 : allRecipesFromDb) {
	recipeList.add(recipe3);
	}
	Assertions.assertThat(recipeList.size()).isEqualTo(1);
	}
	}
}

*/
