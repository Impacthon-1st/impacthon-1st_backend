package com.gil.impacthon1st_backend.domain.party.domain.repository

import com.gil.impacthon1st_backend.domain.party.domain.Party
import com.gil.impacthon1st_backend.domain.party.domain.PartyMember
import org.springframework.data.jpa.repository.JpaRepository

interface PartyMemberJpaRepository : JpaRepository<PartyMember, Long> {
    fun findAllByParty(party: Party): List<PartyMember>
}
