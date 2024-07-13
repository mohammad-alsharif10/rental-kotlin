package com.learning.rentalkotlin.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.ColumnDefault
import java.time.Instant

@Entity
@Table(name = "country", schema = "public")
open class Country {
    @Id
    @ColumnDefault("nextval('country_country_id_seq'::regclass)")
    @Column(name = "country_id", nullable = false)
    open var id: Int? = null

    @Size(max = 50)
    @NotNull
    @Column(name = "country", nullable = false, length = 50)
    open var country: String? = null

    @NotNull
    @ColumnDefault("now()")
    @Column(name = "last_update", nullable = false)
    open var lastUpdate: Instant? = null
}