package com.learning.rentalkotlin.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.ColumnDefault
import java.time.Instant

@Entity
@Table(
    name = "actor", schema = "public", indexes = [
        Index(name = "idx_actor_last_name", columnList = "last_name")
    ]
)
open class Actor {
    @Id
    @ColumnDefault("nextval('actor_actor_id_seq'::regclass)")
    @Column(name = "actor_id", nullable = false)
    open var id: Int? = null

    @Size(max = 45)
    @NotNull
    @Column(name = "first_name", nullable = false, length = 45)
    open var firstName: String? = null

    @Size(max = 45)
    @NotNull
    @Column(name = "last_name", nullable = false, length = 45)
    open var lastName: String? = null

    @NotNull
    @ColumnDefault("now()")
    @Column(name = "last_update", nullable = false)
    open var lastUpdate: Instant? = null
}