package com.fitness.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component 									//so that we can autowire it...
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	// Commence method will execute when unauthorize request trying to access authorize api...
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		//sending unauth error response when client trying to access secured api without jwt..
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Access Denied");
		
	}

}
