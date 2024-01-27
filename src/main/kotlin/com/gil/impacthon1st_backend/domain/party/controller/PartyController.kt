package com.gil.impacthon1st_backend.domain.party.controller

import com.gil.impacthon1st_backend.domain.party.controller.dto.request.CreatePartyRequest
import com.gil.impacthon1st_backend.domain.party.controller.dto.response.QueryCurrentPartyResponse
import com.gil.impacthon1st_backend.domain.party.controller.dto.response.QueryPartyListResponse
import com.gil.impacthon1st_backend.domain.party.service.CreatePartyService
import com.gil.impacthon1st_backend.domain.party.service.EnterAgreePartyService
import com.gil.impacthon1st_backend.domain.party.service.EnterRequestPartyService
import com.gil.impacthon1st_backend.domain.party.service.QueryCurrentPartyService
import com.gil.impacthon1st_backend.domain.party.service.QueryPartyListService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/parties")
@RestController
class PartyController(
    private val createPartyService: CreatePartyService,
    private val enterRequestPartyService: EnterRequestPartyService,
    private val enterAgreePartyService: EnterAgreePartyService,
    private val queryPartyListService: QueryPartyListService,
    private val queryCurrentPartyService: QueryCurrentPartyService,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createParty(@RequestBody @Valid request: CreatePartyRequest) {
        createPartyService.execute(request)
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{party-id}")
    fun enterRequestParty(@PathVariable("party-id") partyId: Long) {
        enterRequestPartyService.execute(partyId)
    }

    @PatchMapping("/{party-member-id}")
    fun enterAgreeParty(@PathVariable("party-member-id") partyMemberId: Long) {
        enterAgreePartyService.execute(partyMemberId)
    }

    @GetMapping
    fun queryPartyList(): QueryPartyListResponse =
        queryPartyListService.execute()

    @GetMapping("/current")
    fun queryCurrentParty(): QueryCurrentPartyResponse =
        queryCurrentPartyService.execute()
}