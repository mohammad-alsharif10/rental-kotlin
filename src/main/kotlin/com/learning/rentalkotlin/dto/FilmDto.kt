package com.learning.rentalkotlin.dto

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import java.io.Serializable
import java.math.BigDecimal
import java.time.Instant

/**
 * DTO for {@link com.learning.rentalkotlin.entity.Film}
 */

data class FilmDto(
    val id: Int? = null,
    @field:NotNull @field:Size(max = 255) val title: String? = null,
    val description: String? = null,
    val releaseYear: Int? = null,
    @field:NotNull val language: LanguageDto? = null,
    @field:NotNull val rentalDuration: Short? = null,
    @field:NotNull val rentalRate: BigDecimal? = null,
    val length: Short? = null,
    @field:NotNull val replacementCost: BigDecimal? = null,
    @field:NotNull val lastUpdate: Instant? = null,
    val specialFeatures: List<String> = emptyList<String>(),
    @field:Pattern(regexp = "^(G|PG|PG-13|R|NC-17)\$") val rating: String? = null
) : Serializable