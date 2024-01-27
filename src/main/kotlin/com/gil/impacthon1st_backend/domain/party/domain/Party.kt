package com.gil.impacthon1st_backend.domain.party.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.jetbrains.annotations.NotNull
import java.time.LocalDateTime

@Entity
class Party(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(columnDefinition = "DATETIME")
    val meetAt: LocalDateTime,

    @NotNull
    @Column(columnDefinition = "FLOAT")
    val meetPlaceXPoint: Float,

    @NotNull
    @Column(columnDefinition = "FLOAT")
    val meetPlaceYPoint: Float,

    @NotNull
    @Column(columnDefinition = "VARCHAR(100)")
    val meetPlace: String,

    @NotNull
    @Column(columnDefinition = "INT")
    val count: Int,

    @NotNull
    @Column(columnDefinition = "FLOAT")
    val visitPlaceXPoint: Float,

    @NotNull
    @Column(columnDefinition = "FLOAT")
    val visitPlaceYPoint: Float,

    @NotNull
    @Column(columnDefinition = "VARCHAR(100)")
    val visitPlace: String,

    @NotNull
    @Column(columnDefinition = "VARCHAR(4000)")
    val content: String,

    @NotNull
    @Column(columnDefinition = "VARCHAR(4000)")
    val chatLink: String,
)