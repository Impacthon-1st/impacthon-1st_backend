package com.gil.impacthon1st_backend.domain.user.controller.dto.request

data class LoginRequest(
    val accountId: String,
    val password: String,
)
