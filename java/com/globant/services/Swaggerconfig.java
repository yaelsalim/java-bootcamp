package com.globant.services;

import static springfox.documentation.builders.PathSelectors.regex;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = {
	    APIcontroller.class
	})
public class Swaggerconfig  {
	
	
	@Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("api")
        		                 .apiInfo(apiInfo())
        		                 .directModelSubstitute(LocalDateTime.class, Date.class)
        		                 .select()
        		                 .paths(regex("/.*"))
        		                 .build();
              
    }
     
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Shopping Cart REST API")
                .description("Shopping Cart REST API with Swagger")
                .termsOfServiceUrl("http://globant.com")
                .license("")
                .licenseUrl("")
                .version("1.0")
                .build();
    }
}


