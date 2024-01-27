package com.gil.impacthon1st_backend.domain.user.service

import com.gil.impacthon1st_backend.domain.user.controller.dto.response.QueryMyInfoResponse
import com.gil.impacthon1st_backend.domain.user.domain.repository.UserJpaRepository
import com.gil.impacthon1st_backend.global.exception.NotFoundException
import com.gil.impacthon1st_backend.global.security.SecurityAdapter
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class QueryMyInfoService(
    private val userJpaRepository: UserJpaRepository,
    private val securityAdapter: SecurityAdapter,
) {

    fun execute(): QueryMyInfoResponse {
        val currentUserId = securityAdapter.getCurrentUserId()

        val user = userJpaRepository.findByIdOrNull(currentUserId)
            ?: throw NotFoundException("User Not Found")

        return QueryMyInfoResponse(
            number = user.number,
            birthday = user.birthday,
            name = user.name,
            gender = user.gender,
            mbti = user.mbti,
            profileImageUrl = user.profileImageUrl
        )
    }
}