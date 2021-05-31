package com.food.recipe.web.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.food.recipe.web.app.DAO.RecipeDao;
import com.food.recipe.web.app.entities.Recipes;
import com.food.recipe.web.app.exceptionHandler.RecipeNotFoundException;
//import com.java.recipe.guid.crudoperations.exception.RecipeNotFoundException;

import springfox.documentation.swagger2.mappers.ModelMapper;

@Service
public class RecipeServiceImpl implements RecipeService {

	//Logger logger = LoggerFactory.getLogger(RecipeServiceImpl.class);
	//List<Recipes> list;
	
	@Autowired
	private RecipeDao recipeDao;
	
	
	public RecipeServiceImpl() {
	
		//list= new ArrayList<>();
		//list.add(new Recipes(1435,"Biryani","Made by chef of hindustan"));
		//list.add(new Recipes(1436,"Biryani masala","Made by chef of hindustan"));
	}
	
	public List<Recipes> getRecipes() {
		return recipeDao.findAll();
	}

	public Optional<Recipes> getRecipe(long recipeId){
		
		//logger.info("RecipeServiceImpl || getOneId()");
		//ModelMapper modelMapper = new ModelMapper();
	//	return  modelMapper.mapModels(recipeDao.getOne(recipeId).)
		//return recipeDao.getOne(recipeId);
		return recipeDao.findById(recipeId);
	}

	@Override
	public Recipes addRecipe(Recipes recipe) {
		//list.add(recipe);
		recipeDao.save(recipe);
		return recipe;
	}

	@Override
	public Recipes updateRecipe(Recipes recipe) {
		
		//recipeDao.save(recipe);
		recipeDao.save(recipe);
		return recipe;
	}

	@Override
	public void deleteRecipe(long recipeId){
	   // list=this.list.stream().filter(re->re.getId()!=parseLong).collect(Collectors.toList());
		//Recipes entity=recipeDao.findById(parseLong);
		//Optional<Recipes> entity=recipeDao.findById(parseLong);
		 recipeDao.deleteById(recipeId);
	}
}
