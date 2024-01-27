package com.gil.impacthon1st_backend.global.swagger

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.servers.Server
import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders

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
                .addSecuritySchemes("Access Token (Bearer)", createAPIKeyScheme())
        )
        .addSecurityItem(
            SecurityRequirement()
                .addList("Access Token (Bearer)")
                .addList("Refresh Token")
        )

    private fun createAPIKeyScheme(): SecurityScheme {
        return SecurityScheme()
            .type(SecurityScheme.Type.HTTP)
            .scheme("bearer")
            .bearerFormat("JWT")
            .`in`(SecurityScheme.In.HEADER)
            .name(HttpHeaders.AUTHORIZATION);
    }
}
