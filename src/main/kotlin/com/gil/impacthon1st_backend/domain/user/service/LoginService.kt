package com.gil.impacthon1st_backend.domain.user.service

import com.gil.impacthon1st_backend.domain.user.controller.dto.request.LoginRequest
import com.gil.impacthon1st_backend.domain.user.controller.dto.response.TokenResponse
import com.gil.impacthon1st_backend.domain.user.domain.repository.UserJpaRepository
import com.gil.impacthon1st_backend.global.exception.ForbiddenException
import com.gil.impacthon1st_backend.global.exception.NotFoundException
import com.gil.impacthon1st_backend.global.security.SecurityAdapter
import com.gil.impacthon1st_backend.global.security.jwt.JwtTokenAdapter
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LoginService(
    private val userJpaRepository: UserJpaRepository,
    private val jwtTokenAdapter: JwtTokenAdapter,
    private val securityAdapter: SecurityAdapter,
) {

    @Transactional
    fun execute(request: LoginRequest): TokenResponse {
        val user = userJpaRepository.findByAccountId(request.accountId)
            ?: throw NotFoundException("User Not Found")

        if (!securityAdapter.passwordMatches(request.password, user.password)) {
            throw ForbiddenException("Invalid Password")
        }

        return jwtTokenAdapter.generateTokens(user.id)
    }
}