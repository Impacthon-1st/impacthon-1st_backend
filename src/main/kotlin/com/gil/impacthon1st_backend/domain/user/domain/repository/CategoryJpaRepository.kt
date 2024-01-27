package com.gil.impacthon1st_backend.domain.user.domain.repository

import com.gil.impacthon1st_backend.domain.user.domain.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryJpaRepository : JpaRepository<Category, Long> {
}