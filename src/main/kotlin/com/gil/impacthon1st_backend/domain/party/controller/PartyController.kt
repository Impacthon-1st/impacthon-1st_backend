package com.gil.impacthon1st_backend.domain.party.controller

import com.gil.impacthon1st_backend.domain.party.controller.dto.request.CreatePartyRequest
import com.gil.impacthon1st_backend.domain.party.service.CreatePartyService
import com.gil.impacthon1st_backend.domain.party.service.EnterPartyService
import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
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
    private val enterPartyService: EnterPartyService,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createParty(@RequestBody @Valid request: CreatePartyRequest) {
        createPartyService.execute(request)
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{party-id}")
    fun enterParty(@PathVariable("party-id") partyId: Long) {
        enterPartyService.execute(partyId)
    }
}