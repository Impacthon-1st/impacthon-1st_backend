package com.gil.impacthon1st_backend.domain.user.controller.dto.request

import com.gil.impacthon1st_backend.domain.user.domain.Gender
import com.gil.impacthon1st_backend.domain.user.domain.MBTI
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.jetbrains.annotations.NotNull
import java.time.LocalDate

data class CreateUserRequest(
    @field:Size(max = 30)
    @field:NotBlank
    val accountId: String,

    @field:NotBlank
    val password: String,

    @field:Size(max = 30)
    @field:NotBlank
    val number: String,

    @field:Size(max = 30)
    @field:NotBlank
    val name: String,

    @NotNull
    val birthday: LocalDate,

    @NotNull
    val gender: Gender,

    @NotNull
    val mbti: MBTI,

    @NotNull
    val category: List<String>,

    @NotNull
    val profileImageUrl: String,
)