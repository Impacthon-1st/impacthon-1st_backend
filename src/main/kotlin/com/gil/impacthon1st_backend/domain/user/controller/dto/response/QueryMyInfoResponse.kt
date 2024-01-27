package com.gil.impacthon1st_backend.domain.user.controller.dto.response

import com.gil.impacthon1st_backend.domain.user.domain.Gender
import com.gil.impacthon1st_backend.domain.user.domain.MBTI
import java.time.LocalDate

data class QueryMyInfoResponse(
    val number: String,
    val birthday: LocalDate,
    val name: String,
    val gender: Gender,
    val mbti: MBTI,
    val profileImageUrl: String,
)