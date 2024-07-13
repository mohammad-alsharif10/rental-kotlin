package com.learning.rentalkotlin.dto

import com.learning.rentalkotlin.entity.Language
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.io.Serializable
import java.time.Instant

/**
 * DTO for {@link com.learning.rentalkotlin.entity.Language}
 */
data class LanguageDto(
    val id: Int? = null,
    @field:NotNull @field:Size(max = 20) val name: String? = null,
    @field:NotNull val lastUpdate: Instant? = null
) : Serializable