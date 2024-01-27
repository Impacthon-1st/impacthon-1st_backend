package com.gil.impacthon1st_backend.domain.party.domain.repository

import com.gil.impacthon1st_backend.domain.party.domain.Party
import org.springframework.data.jpa.repository.JpaRepository

interface PartyJpaRepository : JpaRepository<Party, Long> {
}