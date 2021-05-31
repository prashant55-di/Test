package com.food.recipe.web.app.advice;

import java.util.Date;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.food.recipe.web.app.exceptionHandler.ExceptionDescrption;
import com.food.recipe.web.app.exceptionHandler.RecipeNotFoundException;

@ControllerAdvice
public class RecipeExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionDescrption> handleGlobalException(Exception exception, WebRequest webRequest){

		//ExceptionDescrption exceptionDescrption = new ExceptionDescrption (new Date(), webRequest.getDescription(false),exception.getMessage()); 
		ExceptionDescrption exceptionDescrption = new ExceptionDescrption ( new Date(), exception.getMessage(),webRequest.getDescription(false));
	return new ResponseEntity<>(exceptionDescrption,HttpStatus.BAD_REQUEST);	
	}
	
	/* @ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException element)
	{
		return new ResponseEntity<Object>("No value is present in DB, Please change the request",HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException
			httpResponseMethodNotSupported, HttpHeaders headers, HttpStatus status, WebRequest webRequest)
	{
		return new ResponseEntity<Object>("Please change http method type",HttpStatus.NOT_FOUND);
	}
	*/
	
	@ExceptionHandler(RecipeNotFoundException.class)
	public ResponseEntity<ExceptionDescrption> handleRecipeNotFoundException(RecipeNotFoundException
			recipeNotFoundException, HttpHeaders headers, HttpStatus status, WebRequest webRequest)
	{
		ExceptionDescrption exceptionDescrption = new ExceptionDescrption (new Date(),recipeNotFoundException.getMessage(),webRequest.getDescription(false));
		return new ResponseEntity<>(exceptionDescrption ,HttpStatus.NOT_FOUND);
	}
	
	
/*@ExceptionHandler(IllegalArgumentException.class)	
public ResponseEntity<Object> handleIllegalArgumentException (IllegalArgumentException exception , WebRequest webRequest)
{
	final String  ERROR_MESSAGE= exception.getMessage();
	ApiErrorResponse errorResponse= getErrorResponse(HttpStatus.BAD_REQUEST,ERROR_MESSAGE);
	
	return handleExceptionInternal(exception,errorResponse,new HttpHeaders(),
			HttpStatus.BAD_REQUEST,webRequest);
}*/
}
