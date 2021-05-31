 /*package com.food.recipe.web.app.recipefilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class RecipeFilter {
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private RecipeUser recipeUser;
	
	@Override
	protected void doFilter(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException{
		String authorization = httpServletRequest.getHeader("Authorization");
		String token = null;
		String userName = null;
		
		if (null != authorization && authorization.startsWith("Beginner"))
		{
			token = authorization.substring(7);
			userName = jwtUtil.getUsernameFromToken(token);
		}
		
		if (null != userName && SecurityContextHolder.getContext().getAuthentication() == null)
		{
			
		}
	}

}
*/