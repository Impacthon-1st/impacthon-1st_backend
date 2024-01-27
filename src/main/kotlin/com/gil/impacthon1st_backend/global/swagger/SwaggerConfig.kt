package com.gil.impacthon1st_backend.global.swagger

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.servers.Server
import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@OpenAPIDefinition(servers = [Server(url = "https://precise-socially-mackerel.ngrok-free.app")])
@Configuration
class SwaggerConfig {

    @Bean
    fun openAPI(): OpenAPI = OpenAPI()
        .info(
            Info().title("해커톤 6팀 API")
                .description("해커톤 6팀 API 명세입니다.")
                .version("v1"),
        )
        .components(
            Components()
                .addSecuritySchemes("Bearer Token", createAPIKeyScheme())
        )

    private fun createAPIKeyScheme(): SecurityScheme {
        return SecurityScheme().type(SecurityScheme.Type.HTTP)
            .bearerFormat("JWT")
            .scheme("bearer")
    }
}
