package com.learning.rentalkotlin.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.math.BigDecimal
import java.time.Instant

@Entity
@Table(name = "film", schema = "public", indexes = [
    Index(name = "idx_title", columnList = "title"),
    Index(name = "idx_fk_language_id", columnList = "language_id"),
    Index(name = "film_fulltext_idx", columnList = "fulltext")
])
open class Film {
    @Id
    @ColumnDefault("nextval('film_film_id_seq'::regclass)")
    @Column(name = "film_id", nullable = false)
    open var id: Int? = null

    @Size(max = 255)
    @NotNull
    @Column(name = "title", nullable = false)
    open var title: String? = null

    @Column(name = "description", length = Integer.MAX_VALUE)
    open var description: String? = null

    @Column(name = "release_year")
    open var releaseYear: Int? = null

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "language_id", nullable = false)
    open var language: com.learning.rentalkotlin.entity.Language? = null

    @NotNull
    @ColumnDefault("3")
    @Column(name = "rental_duration", nullable = false)
    open var rentalDuration: Short? = null

    @NotNull
    @ColumnDefault("4.99")
    @Column(name = "rental_rate", nullable = false, precision = 4, scale = 2)
    open var rentalRate: BigDecimal? = null

    @Column(name = "length")
    open var length: Short? = null

    @NotNull
    @ColumnDefault("19.99")
    @Column(name = "replacement_cost", nullable = false, precision = 5, scale = 2)
    open var replacementCost: BigDecimal? = null

    @NotNull
    @ColumnDefault("now()")
    @Column(name = "last_update", nullable = false)
    open var lastUpdate: Instant? = null

    @Column(name = "special_features")
    open var specialFeatures: MutableList<String>? = null

    /*
         TODO [Reverse Engineering] create field to map the 'rating' column
         Available actions: Define target Java type | Uncomment as is | Remove column mapping
            @ColumnDefault("'G'::mpaa_rating")
            @Column(name = "rating", columnDefinition = "mpaa_rating")
            open var rating: Any? = null
        */
    /*
         TODO [Reverse Engineering] create field to map the 'fulltext' column
         Available actions: Define target Java type | Uncomment as is | Remove column mapping
            @Column(name = "fulltext", columnDefinition = "tsvector not null")
            open var fulltext: Any? = null
        */
}