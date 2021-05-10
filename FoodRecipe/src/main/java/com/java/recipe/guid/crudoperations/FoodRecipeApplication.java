package com.java.recipe.guid.crudoperations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableJpaRepositories(basePackages="com.java.recipe.guid.crudoperations.repository")
public class FoodRecipeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodRecipeApplication.class, args);
		
	}

}
