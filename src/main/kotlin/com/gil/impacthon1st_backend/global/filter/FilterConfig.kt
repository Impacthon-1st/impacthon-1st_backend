package com.gil.impacthon1st_backend.global.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.gil.impacthon1st_backend.global.security.jwt.JwtTokenParser
import org.springframework.security.config.annotation.SecurityConfigurer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.stereotype.Component

@Component
class FilterConfig(
    private val jwtTokenParser: JwtTokenParser,
    private val objectMapper: ObjectMapper,
) : SecurityConfigurer<DefaultSecurityFilterChain, HttpSecurity> {

    override fun configure(http: HttpSecurity) {
        http.addFilterBefore(JwtFilter(jwtTokenParser), UsernamePasswordAuthenticationFilter::class.java)
        http.addFilterBefore(GlobalExceptionFilter(objectMapper), JwtFilter::class.java)
    }

    override fun init(http: HttpSecurity) {
    }
}
