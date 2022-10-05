package com.fitness.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fitness.security.CustomeUserDetailService;
import com.fitness.security.JwtAuthenticationEntryPoint;
import com.fitness.security.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableWebMvc  //for swagger
@EnableGlobalMethodSecurity(prePostEnabled = true) // to apply security over each method...
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	//string combination for swagger UI... 
	public static final String[] PUBLIC_URLS = {
			"/v3/api-docs",
			"/v2/api-docs",
			"/api/v1/auth/login",
			"/api/v1/auth/customer",
			
			"/swagger-resources/**",
			"/swagger-ui/**",
			"/webjars/**"
	};

	@Autowired
	private CustomeUserDetailService customeUserDetailservice;

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Basic Authentication...

		http
		.csrf()
		.disable()
		.authorizeRequests()
//		.antMatchers("/v3/api-docs").permitAll()
//		.antMatchers("/api/v1/auth/login")// login and register both intercepted...
//				.permitAll()
//		.antMatchers("/api/v1/auth/customer").permitAll()
		.antMatchers(PUBLIC_URLS).permitAll()
		.antMatchers("/api/v1/auth/manager").hasAnyRole("ADMIN")
		.antMatchers("/api/v1/auth/admin").hasAnyRole("ADMIN")
		.antMatchers("/api/user/**").hasAnyRole("ADMIN","MANAGER","CUSTOMER")
				.antMatchers("/api/branch/**").hasAnyRole("ADMIN")
				.antMatchers("/api/package/**").hasAnyRole("ADMIN")  //done...
				.antMatchers("/api/report/**").hasAnyRole("MANAGER","ADMIN")
				// .antMatchers(HttpMethod.GET).permitAll() //so this will allow any user to
				// access all get methods...
				.anyRequest()
				.authenticated()
				.and()
				.exceptionHandling()
				.authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
				.and()
				.sessionManagement() // for session to be worked on stateless policy...																				
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

	}

	// we want basic authentication as well as we need to do authen from db..for
	// that...
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.customeUserDetailservice).passwordEncoder(passwordEncoder());
		super.configure(auth);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
//	@Bean
//	public FilterRegistrationBean coresFilter() {
//		
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	
//		
//		CorsConfiguration corsConfiguration=new CorsConfiguration();
//		corsConfiguration.setAllowCredentials(true);
//		corsConfiguration.addAllowedOriginPattern("*");
//		corsConfiguration.addAllowedHeader("Autherization");
//		corsConfiguration.addAllowedHeader("Content-Type");
//		corsConfiguration.addAllowedHeader("Acceept");
//		corsConfiguration.addAllowedHeader("POST");
//		corsConfiguration.addAllowedHeader("GET");
//		corsConfiguration.addAllowedHeader("DELETE");
//		corsConfiguration.addAllowedHeader("PUT");
//		corsConfiguration.addAllowedHeader("OPTIONS");
//		corsConfiguration.setMaxAge(3600L);
//		
//	    source.registerCorsConfiguration("/**", corsConfiguration);
//		FilterRegistrationBean bean=new FilterRegistrationBean(new CorsFilter(source));
//		
//		return bean;
//		

	

}
