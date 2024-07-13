package com.learning.rentalkotlin.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.time.Instant
import java.time.LocalDate

@Entity
@Table(name = "customer", schema = "public", indexes = [
    Index(name = "idx_fk_store_id", columnList = "store_id"),
    Index(name = "idx_last_name", columnList = "last_name"),
    Index(name = "idx_fk_address_id", columnList = "address_id")
])
open class Customer {
    @Id
    @ColumnDefault("nextval('customer_customer_id_seq'::regclass)")
    @Column(name = "customer_id", nullable = false)
    open var id: Int? = null

    @NotNull
    @Column(name = "store_id", nullable = false)
    open var storeId: Short? = null

    @Size(max = 45)
    @NotNull
    @Column(name = "first_name", nullable = false, length = 45)
    open var firstName: String? = null

    @Size(max = 45)
    @NotNull
    @Column(name = "last_name", nullable = false, length = 45)
    open var lastName: String? = null

    @Size(max = 50)
    @Column(name = "email", length = 50)
    open var email: String? = null

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "address_id", nullable = false)
    open var address: Address? = null

    @NotNull
    @ColumnDefault("true")
    @Column(name = "activebool", nullable = false)
    open var activebool: Boolean? = false

    @NotNull
    @ColumnDefault("('now'::text)::date")
    @Column(name = "create_date", nullable = false)
    open var createDate: LocalDate? = null

    @ColumnDefault("now()")
    @Column(name = "last_update")
    open var lastUpdate: Instant? = null

    @Column(name = "active")
    open var active: Int? = null
}