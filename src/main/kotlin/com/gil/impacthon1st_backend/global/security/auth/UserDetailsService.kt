package com.gil.impacthon1st_backend.global.security.auth

import com.gil.impacthon1st_backend.domain.user.domain.User
import com.gil.impacthon1st_backend.domain.user.domain.repository.UserJpaRepository
import com.gil.impacthon1st_backend.global.exception.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsService(
    private val userJpaRepository: UserJpaRepository,
) : UserDetailsService {

    override fun loadUserByUsername(userId: String): UserDetails {
        val user: User = userJpaRepository.findByIdOrNull(userId.toLong())
            ?: throw NotFoundException("User Not Found")

        return UserDetails(user.id)
    }
}
