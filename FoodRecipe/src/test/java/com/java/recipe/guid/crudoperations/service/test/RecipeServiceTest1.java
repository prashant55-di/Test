/* package com.java.recipe.guid.crudoperations.service.test;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.util.Arrays;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.recipe.guid.crudoperations.exception.RecipeNotFoundException;
import com.java.recipe.guid.crudoperations.model.RecipeEntity;
import com.java.recipe.guid.crudoperations.repository.RecipeRepository;
import com.java.recipe.guid.crudoperations.service.RecipeService;

public class RecipeServiceTest1 {

	@InjectMocks
	RecipeService recipeService;
	
	@Mock
	RecipeRepository recipeRepository;
	
	@Autowired
    private MockMvc mockMvc;
	
	@BeforeEach
	public void setUp() throws Exception {
	MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetById() throws Exception {
		
		 ObjectMapper mapper = new ObjectMapper();
		 RecipeEntity recipeEnity =new RecipeEntity(1L,"Biryani","Ingrediants1","step1");

	        String body =mapper.writeValueAsString(recipeEnity);
	        MvcResult response= ( (ResultActions) ((MockHttpServletRequestBuilder) mockMvc.perform(MockMvcRequestBuilders.get("/recipees/123")))
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(body)
	                
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().is2xxSuccessful())
	                .andReturn();
	        System.out.println(response);
	}
	
	@Test
	public void createRecipees() throws Exception {
		RecipeEntity recipeEnity = new RecipeEntity(1, "Biryani", "Ingrediants1","Steps1");
		
		Mockito.when(
				recipeService.createRecipe(recipeEnity)).thenReturn(recipeEnity);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/recipees")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

		assertEquals("http://localhost/api/recp1/recipees/",
				response.getHeader(HttpHeaders.LOCATION));

	
	}
}
//}   
	/*ResponseEntity<RecipeEntity> responseEntity = new ResponseEntity<>(recipEntity,HttpStatus.OK);
		ResponseEntity <RecipeEntity> recipeEnity = new ResponseEntity(1L,"Biryani","Ingrediants1","step1");
	recipeEnity.setId(1L);
   
	Mockito.when(recipeRepository.findById(anyLong())).thenReturn(recipeEnity,HttpStatus.OK);
	
	ResponseEntity responseEntity = recipeService.getById(1L);		
	assertNotNull(responseEntity);
	assertEquals(1l, 1L);
	}*/
	
	/* @Test (expected=RecipeNotFoundException.class)
	public void testGetById_RecipeNotFoundException() throws RecipeNotFoundException
	{
		when(recipeRepository.findById(anyLong())).thenReturn(123);
		recipeService.getById(123);
		 
	} */
	
	/* @Test
	public void testDeleteId() throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		RecipeEntity recipeEnity =new RecipeEntity(1L,"Biryani","Ingrediants1","step1");
		
		//when(recipeRepository.findById(anyLong()).thenReturn(recipeEnity);
		String body =mapper.writeValueAsString(recipeEnity);
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete("{id}", new Long(1)))
				.andReturn();

		int status = result.getResponse().getStatus();
		assertEquals("Incorrect Response Status", HttpStatus.GONE.value(), status);

		verify(recipeService).deleteById(anyLong());
	} 


*/