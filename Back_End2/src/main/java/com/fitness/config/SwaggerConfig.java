package com.fitness.config;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	public static final String AUTHORIZATION_HEADER = "Authorization";

	private ApiKey apikeys() {
		return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
	}

	private List<SecurityReference> securityReference() {

		AuthorizationScope scopes = new springfox.documentation.service.AuthorizationScope("global",
				"accessEverything");

		return java.util.Arrays.asList(new SecurityReference("JWT", new AuthorizationScope[] { scopes }));

	}

	private List<springfox.documentation.spi.service.contexts.SecurityContext> securityContext() {

		return java.util.Arrays.asList(springfox.documentation.spi.service.contexts.SecurityContext.builder()
				.securityReferences(securityReference()).build());
	}

	@Bean // automatically inject when ss required
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getInfo()).securityContexts(securityContext())
				.securitySchemes(java.util.Arrays.asList(apikeys())).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();

	}

	private ApiInfo getInfo() {

		return new ApiInfo("Fitness Application : Backend Part", "This project is developed by Group 27", "1.0",
				"Terms of service",
				new Contact("Bhushan & Shubham", "http://localhost:9090/api/v1/package/",
						"bhushanlokhande10.bl@gmail.com"),
				"License of Apis", "API license URL", Collections.EMPTY_LIST);
	}

}
