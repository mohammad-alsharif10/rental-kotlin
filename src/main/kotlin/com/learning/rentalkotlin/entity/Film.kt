package com.learning.rentalkotlin.entity

import com.learning.rentalkotlin.dto.FilmDto
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.math.BigDecimal
import java.time.Instant

@Entity
@Table(
    name = "film", schema = "public", indexes = [
        Index(name = "idx_title", columnList = "title"),
        Index(name = "idx_fk_language_id", columnList = "language_id"),
        Index(name = "film_fulltext_idx", columnList = "fulltext")
    ]
)
class Film {
    @Id
    @ColumnDefault("nextval('film_film_id_seq'::regclass)")
    @Column(name = "film_id", nullable = false)
    var id: Int? = null

    @Size(max = 255)
    @NotNull
    @Column(name = "title", nullable = false)
    var title: String? = null

    @Column(name = "description", length = Integer.MAX_VALUE)
    var description: String? = null

    @Column(name = "release_year")
    var releaseYear: Int? = null

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "language_id", nullable = false)
    var language: Language? = null

    @NotNull
    @ColumnDefault("3")
    @Column(name = "rental_duration", nullable = false)
    var rentalDuration: Short? = null

    @NotNull
    @ColumnDefault("4.99")
    @Column(name = "rental_rate", nullable = false, precision = 4, scale = 2)
    var rentalRate: BigDecimal? = null

    @Column(name = "length")
    var length: Short? = null

    @NotNull
    @ColumnDefault("19.99")
    @Column(name = "replacement_cost", nullable = false, precision = 5, scale = 2)
    var replacementCost: BigDecimal? = null

    @NotNull
    @ColumnDefault("now()")
    @Column(name = "last_update", nullable = false)
    var lastUpdate: Instant? = null

    @Column(name = "special_features")
    var specialFeatures: List<String> = emptyList<String>()

    @ColumnDefault("'G'::mpaa_rating")
    @Column(name = "rating", columnDefinition = "mpaa_rating")
    var rating: String? = null

    /*
         TODO [Reverse Engineering] create field to map the 'fulltext' column
         Available actions: Define target Java type | Uncomment as is | Remove column mapping
            @Column(name = "fulltext", columnDefinition = "tsvector not null")
             var fulltext: Any? = null
        */

    fun toFilmDto(): FilmDto {
        return FilmDto(
            id, title, description, releaseYear,
            language?.toLanguageDtp(), rentalDuration, rentalRate,
            length, replacementCost, lastUpdate, specialFeatures,rating
        )
    }
}