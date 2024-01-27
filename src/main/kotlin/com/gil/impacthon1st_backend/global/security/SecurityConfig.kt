package com.gil.impacthon1st_backend.global.security

import com.fasterxml.jackson.databind.ObjectMapper
import com.gil.impacthon1st_backend.global.filter.FilterConfig
import com.gil.impacthon1st_backend.global.security.jwt.JwtTokenParser
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
@Configuration
class SecurityConfig(
    private val jwtTokenParser: JwtTokenParser,
    private val objectMapper: ObjectMapper,
) {

    @Bean
    protected fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .formLogin { it.disable() }
            .csrf { it.disable() }
            .cors {}
            .sessionManagement {
                it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }
            .authorizeHttpRequests {
                it
                    // party
                    .requestMatchers(HttpMethod.POST, "/parties").authenticated()
                    .requestMatchers(HttpMethod.POST, "/parties/{party-id}").authenticated()

                    .anyRequest().permitAll()
            }
            .apply(FilterConfig(jwtTokenParser, objectMapper))

        return http.build()
    }

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()
}
