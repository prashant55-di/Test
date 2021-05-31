package com.food.recipe.web.app.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class RecipeLogger {
	
	Logger logger= (Logger) LoggerFactory.getLogger(RecipeLogger.class);
	
	@Pointcut(value="execution (* com.food.recipe.web.app.*.*.*(..) )")
	public void myPointcut()
	{

	}
			
	@Around("myPointcut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		String methodName=pjp.getSignature().getName();
		String className=pjp.getTarget().getClass().toString();
		Object[] array=pjp.getArgs();
	    logger.info("method invoked"+className+" : "+methodName +"()"+"arguments :"
		+mapper.writeValueAsString(array));
		Object object=pjp.proceed();
		logger.info(className+" : "+methodName + "()" + "Response :"
				+mapper.writeValueAsString(object));
		return object;
	}

}
