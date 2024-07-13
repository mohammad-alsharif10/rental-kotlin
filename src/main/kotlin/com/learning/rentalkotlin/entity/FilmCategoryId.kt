package com.learning.rentalkotlin.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.validation.constraints.NotNull
import org.hibernate.Hibernate
import java.io.Serializable
import java.util.*

@Embeddable
open class FilmCategoryId : Serializable {
    @NotNull
    @Column(name = "film_id", nullable = false)
    open var filmId: Short? = null

    @NotNull
    @Column(name = "category_id", nullable = false)
    open var categoryId: Short? = null
    override fun hashCode(): Int = Objects.hash(filmId, categoryId)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false

        other as FilmCategoryId

        return filmId == other.filmId &&
                categoryId == other.categoryId
    }

    companion object {
        private const val serialVersionUID = 6980865372639319656L
    }
}