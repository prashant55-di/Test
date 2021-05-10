package com.java.recipe.guid.crudoperations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.recipe.guid.crudoperations.model.RecipeEntity;

@Repository
	public interface RecipeRepository extends JpaRepository<RecipeEntity, Long>
	{

	}

