package com.food.recipe.web.app.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class RecipeNotFoundException extends Exception{
	
	private static final long serialVesrionUID = 1L;
	
	public RecipeNotFoundException (String message)
	{
		super(message);
	}

}
