package com.gil.impacthon1st_backend.domain.user.controller

import com.gil.impacthon1st_backend.domain.user.controller.dto.request.CreateUserRequest
import com.gil.impacthon1st_backend.domain.user.controller.dto.response.TokenResponse
import com.gil.impacthon1st_backend.domain.user.service.CreateUserService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/users")
@RestController
class UserController(
    private val createUserService: CreateUserService,
) {

    @PostMapping
    fun createUser(@RequestBody @Valid request: CreateUserRequest): TokenResponse =
        createUserService.execute(request)
}