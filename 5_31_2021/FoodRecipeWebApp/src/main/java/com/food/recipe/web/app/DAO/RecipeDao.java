package com.food.recipe.web.app.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.recipe.web.app.entities.Recipes;

public interface RecipeDao extends JpaRepository<Recipes,Long> 
{
	
}
