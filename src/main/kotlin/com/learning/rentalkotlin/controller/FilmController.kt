package com.learning.rentalkotlin.controller

import com.learning.rentalkotlin.dto.FilmDto
import com.learning.rentalkotlin.entity.Film
import com.learning.rentalkotlin.repository.FilmRepository
import com.learning.rentalkotlin.service.FilmService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/film")
class FilmController(private val filmService: FilmService) {


    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): ResponseEntity<FilmDto> {
        return ResponseEntity.ok(filmService.findById(id));
    }
}