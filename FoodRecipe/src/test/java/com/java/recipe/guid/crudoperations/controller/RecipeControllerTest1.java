/* package com.java.recipe.guid.crudoperations.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoSettings;

import com.java.recipe.guid.crudoperations.exception.RecipeNotFoundException;
import com.java.recipe.guid.crudoperations.model.RecipeEntity;
import com.java.recipe.guid.crudoperations.service.RecipeService;

class RecipeControllerTest1 {

	@InjectMocks
	RecpController recpController;
	
	@Mock
	RecipeService recipeService;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		
		RecipeEntity recipEnity = new RecipeEntity();
		recipEnity.setId(1L);
		recipEnity.setIngrediants("ingrediants1");
		recipEnity.setRecipeName("RecipeName");
		recipEnity.setSteps("step1");
	}

	@Test
	final void test() throws RecipeNotFoundException {
		when(recipeService.getById(anyLong())).thenReturn(null);
	}

	private long anyLong() {
		
		return 0;
	}


}
*/