package com.gil.impacthon1st_backend.domain.user.service

import com.gil.impacthon1st_backend.domain.user.controller.dto.request.CreateUserRequest
import com.gil.impacthon1st_backend.domain.user.controller.dto.response.TokenResponse
import com.gil.impacthon1st_backend.domain.user.domain.Category
import com.gil.impacthon1st_backend.domain.user.domain.User
import com.gil.impacthon1st_backend.domain.user.domain.repository.CategoryJpaRepository
import com.gil.impacthon1st_backend.domain.user.domain.repository.UserJpaRepository
import com.gil.impacthon1st_backend.global.exception.ConflictException
import com.gil.impacthon1st_backend.global.security.SecurityAdapter
import com.gil.impacthon1st_backend.global.security.jwt.JwtTokenAdapter
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateUserService(
    private val userJpaRepository: UserJpaRepository,
    private val categoryJpaRepository: CategoryJpaRepository,
    private val securityAdapter: SecurityAdapter,
    private val jwtTokenAdapter: JwtTokenAdapter,
) {

    @Transactional
    fun execute(request: CreateUserRequest): TokenResponse {
        if (userJpaRepository.existsByAccountId(request.accountId)) {
            throw ConflictException("User Already Exists")
        }

        val user = userJpaRepository.save(
            User(
                accountId = request.accountId,
                password = securityAdapter.encodePassword(request.password),
                number = request.number,
                birthday = request.birthday,
                name = request.name,
                gender = request.gender,
                mbti = request.mbti,
                profileImageUrl = request.profileImageUrl
            )
        )

        categoryJpaRepository.saveAll(
            request.category.map {
                Category(
                    content = it,
                    user = user,
                )
            }
        )

        return jwtTokenAdapter.generateTokens(user.id)
    }
}