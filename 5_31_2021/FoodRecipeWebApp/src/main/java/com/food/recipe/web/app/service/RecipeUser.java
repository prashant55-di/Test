/* package com.food.recipe.web.app.service;

import org.apache.tomcat.jni.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class RecipeUser implements UserDetailsService {
	
 @Override	
 public RecipeUser uploadUserByUserName (String userName ) throws UserNameNotFoundException{
	 if (!userName. equals ("admin"))
	 {
		 throw new UserNameNotFoundException(userName+"Not Found");
	 }
	 
	 return new User("admin" , "password", new ArrayList<>());
 }
	
} */
