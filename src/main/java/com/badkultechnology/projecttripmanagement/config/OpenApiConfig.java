package com.badkultechnology.projecttripmanagement.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
 
	//This configuration pakage is used for swagger OpenApi to use
    @Bean
    public OpenAPI tripApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Trip Manager API")
                        .description("Spring Boot + JPA + Swagger OpenAPI")
                        .version("1.0.0"));
    }
}

