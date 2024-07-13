package com.learning.rentalkotlin.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.time.Instant

@Entity
@Table(name = "store", schema = "public", indexes = [
    Index(name = "idx_unq_manager_staff_id", columnList = "manager_staff_id", unique = true)
])
open class Store {
    @Id
    @ColumnDefault("nextval('store_store_id_seq'::regclass)")
    @Column(name = "store_id", nullable = false)
    open var id: Int? = null

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "manager_staff_id", nullable = false)
    open var managerStaff: Staff? = null

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "address_id", nullable = false)
    open var address: Address? = null

    @NotNull
    @ColumnDefault("now()")
    @Column(name = "last_update", nullable = false)
    open var lastUpdate: Instant? = null
}