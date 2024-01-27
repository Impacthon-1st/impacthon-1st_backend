package com.gil.impacthon1st_backend.global.security.jwt

import com.gil.impacthon1st_backend.domain.user.controller.dto.response.TokenResponse
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID

@Component
class JwtTokenAdapter(
    private val jwtProperties: JwtProperties,
) {

    fun generateTokens(id: UUID): TokenResponse {
        val accessToken = generateAccessToken(id)

        return TokenResponse(
            accessToken = accessToken,
            accessExpiresAt = LocalDateTime.now().plusSeconds(jwtProperties.accessExp.toLong()),
        )
    }

    private fun generateAccessToken(id: UUID): String {
        return generateToken(TokenType.ACCESS, id, jwtProperties.accessExp)
    }

    private fun generateToken(type: TokenType, id: UUID, exp: Int): String {
        return Jwts.builder()
            .setSubject(id.toString())
            .signWith(SignatureAlgorithm.HS256, jwtProperties.secret)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + (exp * 1000)))
            .claim("type", type.name)
            .compact()
    }
}
