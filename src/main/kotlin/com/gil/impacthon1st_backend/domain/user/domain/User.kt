package com.gil.impacthon1st_backend.domain.user.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.jetbrains.annotations.NotNull

@Entity
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @NotNull
    @Column(columnDefinition = "VARCHAR(30)", unique = true)
    val accountId: String,

    @NotNull
    @Column(columnDefinition = "CHAR(60)")
    val password: String,

    @Column(columnDefinition = "VARCHAR(11)")
    val number: String,

    @NotNull
    @Column(columnDefinition = "VARCHAR(30)")
    val name: String,

    @Column(columnDefinition = "INT")
    val age: Int,

    @Column(columnDefinition = "VARCHAR(6)")
    val gender: Gender,

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