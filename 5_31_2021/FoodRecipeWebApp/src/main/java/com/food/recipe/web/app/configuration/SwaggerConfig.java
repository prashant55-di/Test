package com.food.recipe.web.app.configuration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

	private ApiKey apiKey()
	{
		return new ApiKey("JWT","Authorization","header");
	}
	
	private SecurityContext secureContext()
	{
		return  SecurityContext.builder().securityReferences(defaultAuth()).build();
	}
	
	private List<SecurityReference> defaultAuth()
	{
		AuthorizationScope authorizationScope = new AuthorizationScope ("global" , "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		 authorizationScopes [0]= authorizationScope;
		return Arrays.asList(new SecurityReference("JWT",authorizationScopes));
	}
	
	@Bean
	public Docket api()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.securityContexts(Arrays.asList(secureContext()))
				.securitySchemes(Arrays.asList(apiKey()))
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.assignment.recipe.controller"))
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo()
	{
		return new ApiInfo(
				"Recipe Application",
				"Recipes customization applciation .",
				"1.0",
				"Add , Update , Delete , Get the recipes",
				new Contact("Prashant Choubey", "www.capgemini.com", "prashant.choubey@capgemini.com"),
				"",
				"",
				Collections.emptyList());
	}
}