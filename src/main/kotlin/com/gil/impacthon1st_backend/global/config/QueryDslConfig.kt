package com.gil.impacthon1st_backend.global.config

import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class QueryDslConfig(
    private val entityManager: EntityManager,
) {

    @Bean
    fun queryFactory() = JPAQueryFactory(entityManager)
}
