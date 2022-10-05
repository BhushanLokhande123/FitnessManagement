package com.fitness.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtTokenHelper jwtTokenHelper;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		//1.get jwt token from request...from header
		
		String requestToken = request.getHeader("Authorization");//this is key to get jwt value...
		
		//Bearer 753432hgke --> Token is in form of...
		
		System.out.println(requestToken);
		
		String username =null;
		String token=null;
		
		if(requestToken != null && requestToken.startsWith("Bearer")) {
		
			token = requestToken.substring(7);
			
			try {
			username = this.jwtTokenHelper.getUsernameFromToken(token);
			}catch(IllegalArgumentException e) {
				System.out.println("Unable to get jwt token");
			}catch (ExpiredJwtException e) {
				System.out.println("Jwt token has expired");
			}catch (MalformedJwtException e) {
				System.out.println("Invalid jwt");
			}
			
		} 
		else 
		{
		
			System.out.println("Jwt Token does not begin with Bearer...");
		}
		
		//once we get token now validate token...
		
		if(username != null && SecurityContextHolder.getContext().getAuthentication()==null) {
			
			UserDetails userdetails = this.userDetailsService.loadUserByUsername(username);
			
			if(this.jwtTokenHelper.validateToken(token, userdetails)) {
				
				//sahi chl raha
				//authentication karna hai...
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userdetails,null, userdetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				
			}else {
				System.out.println("Invalid jwt token");
			}
		}
		else {
			System.out.println("Username is null or context is null...");
		}
		
		filterChain.doFilter(request, response);
		
		}
		
	}
