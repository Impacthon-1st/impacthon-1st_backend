package com.gil.impacthon1st_backend.global.security

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class SecurityAdapter(
    private val passwordEncoder: PasswordEncoder,
) {

    fun encodePassword(password: String): String =
        passwordEncoder.encode(password)

    fun getCurrentUserId(): UUID = UUID.fromString(
        SecurityContextHolder.getContext().authentication.name,
    )

    fun passwordMatches(rawPassword: String, encodePassword: String): Boolean =
        passwordEncoder.matches(rawPassword, encodePassword)
}
