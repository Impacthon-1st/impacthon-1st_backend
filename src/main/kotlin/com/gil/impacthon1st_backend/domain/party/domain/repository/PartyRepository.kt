package com.gil.impacthon1st_backend.domain.party.domain.repository

import com.gil.impacthon1st_backend.domain.party.controller.dto.response.QueryCurrentPartyResponse
import com.gil.impacthon1st_backend.domain.party.controller.dto.response.PartyResponse
import com.gil.impacthon1st_backend.domain.party.controller.dto.response.QPartyResponse
import com.gil.impacthon1st_backend.domain.party.controller.dto.response.QQueryCurrentPartyResponse
import com.gil.impacthon1st_backend.domain.party.controller.dto.response.QRequestedPartyMemberResponse
import com.gil.impacthon1st_backend.domain.party.controller.dto.response.RequestedPartyMemberResponse
import com.gil.impacthon1st_backend.domain.party.domain.QParty.party
import com.gil.impacthon1st_backend.domain.party.domain.QPartyMember.partyMember
import com.gil.impacthon1st_backend.domain.user.domain.QUser.user
import com.querydsl.core.types.ExpressionUtils.count
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class PartyRepository(
    private val queryFactory: JPAQueryFactory,
) {

    fun queryPartiesByMeetAtIsAfterNow(): List<PartyResponse> =
        queryFactory
            .select(
                QPartyResponse(
                    party.id,
                    party.visitPlace,
                    party.visitPlaceXPoint,
                    party.visitPlaceYPoint,
                    party.count,
                    count(partyMember),
                    user.profileImageUrl,
                    user.name,
                    user.gender,
                    party.meetAt,
                    party.title,
                    party.content
                )
            )
            .from(party)
            .join(party.user, user)
            .join(partyMember)
            .on(partyMember.user.id.eq(user.id))
            .groupBy(party.id)
            .where(party.meetAt.after(LocalDateTime.now()))
            .orderBy(party.meetAt.desc())
            .fetch()

    fun queryPartiesByUserId(userId: Long): QueryCurrentPartyResponse? =
        queryFactory
            .select(
                QQueryCurrentPartyResponse(
                    party.id,
                    party.visitPlace,
                    party.visitPlaceXPoint,
                    party.visitPlaceYPoint,
                    party.user.name,
                    party.user.profileImageUrl,
                    party.createdAt,
                    party.meetAt,
                )
            )
            .from(party)
            .join(partyMember)
            .on(partyMember.party.id.eq(party.id))
            .where(
                party.meetAt.after(LocalDateTime.now()),
                partyMember.user.id.eq(userId)
            )
            .fetchOne()

    fun queryPartyMembersByUserIdAndMeetAtIsAfterNow(userId: Long): List<RequestedPartyMemberResponse> =
        queryFactory
            .select(
                QRequestedPartyMemberResponse(
                    partyMember.id,
                    user.profileImageUrl,
                    user.name,
                )
            )
            .from(partyMember)
            .join(partyMember.party, party)
            .join(party.user, user)
            .where(
                user.id.eq(userId),
                party.meetAt.after(LocalDateTime.now()),
                partyMember.agree.eq(false)
            )
            .fetch()

}