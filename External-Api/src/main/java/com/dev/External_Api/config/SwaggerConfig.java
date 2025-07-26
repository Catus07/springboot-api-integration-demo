package com.dev.External_Api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    OpenAPI openAPI(){
        return new OpenAPI().info(new Info().title("External Apis").description(" a Spring Boot application that demonstrates integration with different types of external APIs — public, API key–secured, and OAuth-style token systems.").summary("created by Revocatus joseph"));
    }
}
