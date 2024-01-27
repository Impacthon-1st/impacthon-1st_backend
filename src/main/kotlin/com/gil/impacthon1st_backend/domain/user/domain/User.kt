package com.gil.impacthon1st_backend.domain.user.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.jetbrains.annotations.NotNull
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @NotNull
    @Column(columnDefinition = "VARCHAR(30)", unique = true)
    val accountId: String,

    @NotNull
    @Column(columnDefinition = "CHAR(60)")
    val password: String,

    @Column(columnDefinition = "VARCHAR(11)")
    val number: String,

    @NotNull
    @Column(columnDefinition = "DATE")
    val birthday: LocalDate,

    @NotNull
    @Column(columnDefinition = "VARCHAR(30)")
    val name: String,

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(6)")
    val gender: Gender,

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "CHAR(4)")
    val mbti: MBTI,
)

enum class Gender {
    MALE, FEMALE, ETC
}

enum class MBTI {
    INTJ,
    INTP,
    ENTJ,
    ENTP,
    INFJ,
    INFP,
    ENFJ,
    ENFP,
    ISTJ,
    ISFJ,
    ESTJ,
    ESFJ,
    ISTP,
    ISFP,
    ESTP,
    ESFP,
}