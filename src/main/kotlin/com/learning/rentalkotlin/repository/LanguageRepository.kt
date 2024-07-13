package com.learning.rentalkotlin.repository;

import com.learning.rentalkotlin.entity.Language
import org.springframework.data.jpa.repository.JpaRepository

interface LanguageRepository : JpaRepository<Language, Int> {
}