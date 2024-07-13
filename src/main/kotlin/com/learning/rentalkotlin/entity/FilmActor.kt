package com.learning.rentalkotlin.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.time.Instant

@Entity
@Table(
    name = "film_actor", schema = "public", indexes = [
        Index(name = "idx_fk_film_id", columnList = "film_id")
    ]
)
open class FilmActor {
    @EmbeddedId
    open var id: FilmActorId? = null

    @MapsId("actorId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "actor_id", nullable = false)
    open var actor: Actor? = null

    @MapsId("filmId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "film_id", nullable = false)
    open var film: Film? = null

    @NotNull
    @ColumnDefault("now()")
    @Column(name = "last_update", nullable = false)
    open var lastUpdate: Instant? = null
}