package com.learning.rentalkotlin.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.time.Instant

@Entity
@Table(name = "rental", schema = "public", indexes = [
    Index(name = "idx_unq_rental_rental_date_inventory_id_customer_id", columnList = "rental_date, inventory_id, customer_id", unique = true),
    Index(name = "idx_fk_inventory_id", columnList = "inventory_id")
])
open class Rental {
    @Id
    @ColumnDefault("nextval('rental_rental_id_seq'::regclass)")
    @Column(name = "rental_id", nullable = false)
    open var id: Int? = null

    @NotNull
    @Column(name = "rental_date", nullable = false)
    open var rentalDate: Instant? = null

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "inventory_id", nullable = false)
    open var inventory: Inventory? = null

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "customer_id", nullable = false)
    open var customer: Customer? = null

    @Column(name = "return_date")
    open var returnDate: Instant? = null

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "staff_id", nullable = false)
    open var staff: com.learning.rentalkotlin.entity.Staff? = null

    @NotNull
    @ColumnDefault("now()")
    @Column(name = "last_update", nullable = false)
    open var lastUpdate: Instant? = null
}