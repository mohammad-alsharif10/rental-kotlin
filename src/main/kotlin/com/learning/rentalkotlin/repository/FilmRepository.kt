package com.learning.rentalkotlin.repository;

import com.learning.rentalkotlin.entity.Film
import org.springframework.data.jpa.repository.JpaRepository

interface FilmRepository : JpaRepository<Film, Int> {
}