package com.learning.rentalkotlin.dto

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.ColumnDefault
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