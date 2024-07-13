package com.learning.rentalkotlin.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.ColumnDefault
import java.time.Instant

@Entity
@Table(name = "city", schema = "public", indexes = [
    Index(name = "idx_fk_country_id", columnList = "country_id")
])
open class City {
    @Id
    @ColumnDefault("nextval('city_city_id_seq'::regclass)")
    @Column(name = "city_id", nullable = false)
    open var id: Int? = null

    @Size(max = 50)
    @NotNull
    @Column(name = "city", nullable = false, length = 50)
    open var city: String? = null

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    open var country: com.learning.rentalkotlin.entity.Country? = null

    @NotNull
    @ColumnDefault("now()")
    @Column(name = "last_update", nullable = false)
    open var lastUpdate: Instant? = null
}