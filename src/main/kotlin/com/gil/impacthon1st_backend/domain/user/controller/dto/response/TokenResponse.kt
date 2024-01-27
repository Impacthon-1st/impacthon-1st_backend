package com.gil.impacthon1st_backend.domain.user.controller.dto.response

import java.time.LocalDateTime

data class TokenResponse(
    val accessToken: String,
    val accessExpiresAt: LocalDateTime,
)
