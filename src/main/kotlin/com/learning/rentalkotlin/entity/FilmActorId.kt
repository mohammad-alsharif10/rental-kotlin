package com.learning.rentalkotlin.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.validation.constraints.NotNull
import org.hibernate.Hibernate
import java.io.Serializable
import java.util.*

@Embeddable
open class FilmActorId : Serializable {
    @NotNull
    @Column(name = "actor_id", nullable = false)
    open var actorId: Short? = null

    @NotNull
    @Column(name = "film_id", nullable = false)
    open var filmId: Short? = null
    override fun hashCode(): Int = Objects.hash(actorId, filmId)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false

        other as FilmActorId

        return actorId == other.actorId &&
                filmId == other.filmId
    }

    companion object {
        private const val serialVersionUID = -3387646421213799108L
    }
}