package com.gil.impacthon1st_backend.domain.party.domain

import com.gil.impacthon1st_backend.domain.user.domain.User
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import org.jetbrains.annotations.NotNull
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime

@Entity
class Party(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @NotNull
    @Column(columnDefinition = "VARCHAR(100)")
    val title: String,

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User,

    @CreatedDate
    val createdAt: LocalDateTime = LocalDateTime.now(),
)