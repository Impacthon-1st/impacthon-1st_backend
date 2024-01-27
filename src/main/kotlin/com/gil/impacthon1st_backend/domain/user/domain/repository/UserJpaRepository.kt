package com.gil.impacthon1st_backend.domain.user.domain.repository

import com.gil.impacthon1st_backend.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository : JpaRepository<User, Long> {
    fun existsByAccountId(accountId: String): Boolean
    fun findByAccountId(accountId: String): User?
}