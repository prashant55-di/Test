/* package com.food.recipe.web.app.utility;

import java.io.Serializable;
import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;

@Component
public class JWTUtil implements Serializable{

	private static final long serailVersionUID=14545678L;
	private static int updateIternalHrs =1;
	private static int updateInternalMin = 60;
	private static int updateInternalSec = 60;
	
	public static final long JWT_TOKEN_VALIDITY = (long)(updateIternalHrs * updateInternalMin * updateInternalSec);
	
	@Value("${jwt.secret}")
	private String secureKey;
	
	
	public String getUsernameFromToken (String token)
	{
		return getClaimFromToken(token, Claims::getSubject);
	}
	
	public Date getExpirationDateFromToken (String token)
	{
		return getClaimFromToken(token, Claims::getExpiration);
	}
	
	public <T> T getClaimFromToken(String token , Function <Claims , T> claimsRes)
	{
		final Claims claims_res = getAllClaimsFromToken(token);
		return  claims_res.apply(claimsRes);
	}
	
	private Boolean IsTokenExpired (String token) {
		final expire = getExpirationDateFromToken(token);
		return expire.before(new Date());
	}
	
} */
