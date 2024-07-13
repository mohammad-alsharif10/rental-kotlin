package com.learning.rentalkotlin.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.time.Instant

@Entity
@Table(
    name = "inventory", schema = "public", indexes = [
        Index(name = "idx_store_id_film_id", columnList = "store_id, film_id")
    ]
)
open class Inventory {
    @Id
    @ColumnDefault("nextval('inventory_inventory_id_seq'::regclass)")
    @Column(name = "inventory_id", nullable = false)
    open var id: Int? = null

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "film_id", nullable = false)
    open var film: Film? = null

    @NotNull
    @Column(name = "store_id", nullable = false)
    open var storeId: Short? = null

    @NotNull
    @ColumnDefault("now()")
    @Column(name = "last_update", nullable = false)
    open var lastUpdate: Instant? = null
}