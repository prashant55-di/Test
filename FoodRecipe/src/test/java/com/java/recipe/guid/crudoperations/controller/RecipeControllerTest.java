/* package com.java.recipe.guid.crudoperations.controller;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.recipe.guid.crudoperations.model.RecipeEntity;
import com.java.recipe.guid.crudoperations.service.RecipeService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RecipeControllerTest {

	@Autowired
	private MockMvc mockMvc;
		
	@Mock
	private RecipeService recipService;
	
	RecipeEntity recipEntity= new RecipeEntity(1L,"recipe-name:Kadhai Panner", "Ingrediants:kadhaipaneer1", "Steps:step1");
	
	ResponseEntity<RecipeEntity> responseEntity = new ResponseEntity<>(recipEntity,HttpStatus.OK);

	@Test
	public void RecipeNotFoundException() throws Exception {

		 Optional<RecipeEntity> currentRecipe = Optional.of(new RecipeEntity());
		 
	        if(currentRecipe.isPresent()) {
	        	RecipeEntity _recipe = currentRecipe.get();
	            _recipe.setId(1l);
	           
	            Mockito.when(recipService.getById(anyLong())).thenReturn(responseEntity);
	            MvcResult result =mockMvc
	            .perform(get("/recipees/" + _recipe.getId()))
	            .andExpect(status().isOk())
	            .andDo(MockMvcResultHandlers.print())
	            .andReturn(); 
	            //.andExpect(status().isNotFound());
	            System.out.println( "Response :"+result.getResponse().getContentAsString());
	            
	            assertEquals(HttpStatus.OK.value(), result.getResponse().getContentAsString());
	        }
	        
	        
	        		//		.getContentAsString(), false);
	}
	//when(recipService.getById(anyLong())).thenReturn(responseEntity);
    
	/*MvcResult response = mockMvc
    .perform(get("/recipees/" + recipe.getId().toString()))
    .andExpect(status().isOk())
    .andExpect(jsonPath("Birayni", is(recipees.getName())))
       .andExpect(jsonPath("Cook with less spicy", is(recipe.getInstructions())*/

	
	/*MvcResult response =  mockMvc.perform(MockMvcRequestBuilders.post("/recipees/123").contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().is2xxSuccessful())
            .andDo(MockMvcResultHandlers.print())
            .andReturn(); */
		/* RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
			"/api/recp1/recipees/123").accept(
			MediaType.APPLICATION_JSON);*/
	
	
	
	//System.out.println("Testing --------");
	//MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	
	//System.out.println("Testing 1----------");
	//System.out.println("Tesing ******"+result.getResponse());
	//String expected = "{id:101,Kadhai Panner,kadhaipaneer1,step1}";

	//JSONAssert.assertEquals(expected, result.getResponse()
	//		.getContentAsString(), false);
	
	/*@PostMapping("/recipees")
	public ResponseEntity<Void> registerStudentForCourse(@PathVariable Long Id, 
			@RequestBody RecipeEntity recipEntity) {

		RecipeEntity recipEntity = RecipeService.addCourse(Id, newRecipeEntity);

		if (recipEntity == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{recipeid}").buildAndExpand(recipEntity.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
}

*/