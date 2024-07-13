package com.learning.rentalkotlin.service

import com.learning.rentalkotlin.dto.FilmDto
import com.learning.rentalkotlin.repository.FilmRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service

@Service
class FilmService(private val filmRepository: FilmRepository) {

    fun findById(id: Int): FilmDto {
       return filmRepository.findById(id).map { it.toFilmDto() }.orElseThrow { throw EntityNotFoundException() }
    }


}