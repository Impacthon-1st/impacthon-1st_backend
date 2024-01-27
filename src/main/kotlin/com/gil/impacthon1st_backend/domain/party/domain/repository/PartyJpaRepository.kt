package com.gil.impacthon1st_backend.domain.party.domain.repository

import com.gil.impacthon1st_backend.domain.party.domain.Party
import com.gil.impacthon1st_backend.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface PartyJpaRepository : JpaRepository<Party, Long> {
    fun existsByUserAndMeetAtIsAfter(user: User, now: LocalDateTime): Boolean
    fun findByUserId(userId: Long): Party?
}