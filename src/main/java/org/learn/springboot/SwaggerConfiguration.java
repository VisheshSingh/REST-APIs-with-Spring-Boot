package org.learn.springboot;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("org.learn.springboot"))
				.paths(PathSelectors.regex("/api.*"))
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo("REST API - Books resource",
				"Spring Boot based REST API",
				"1.0.0",
				"For terms and conditions visit the docs",
				new Contact("V-boy", "v-boy-springboot.org", "v-boy@springboot.org"),
				"GNU",
				"http://www.gnu.org",
				Collections.emptyList());
	}

}
