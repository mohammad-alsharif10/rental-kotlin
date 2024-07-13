package com.learning.rentalkotlin.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.ColumnDefault
import java.time.Instant

@Entity
@Table(name = "address", schema = "public", indexes = [
    Index(name = "idx_fk_city_id", columnList = "city_id")
])
open class Address {
    @Id
    @ColumnDefault("nextval('address_address_id_seq'::regclass)")
    @Column(name = "address_id", nullable = false)
    open var id: Int? = null

    @Size(max = 50)
    @NotNull
    @Column(name = "address", nullable = false, length = 50)
    open var address: String? = null

    @Size(max = 50)
    @Column(name = "address2", length = 50)
    open var address2: String? = null

    @Size(max = 20)
    @NotNull
    @Column(name = "district", nullable = false, length = 20)
    open var district: String? = null

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    open var city: com.learning.rentalkotlin.entity.City? = null

    @Size(max = 10)
    @Column(name = "postal_code", length = 10)
    open var postalCode: String? = null

    @Size(max = 20)
    @NotNull
    @Column(name = "phone", nullable = false, length = 20)
    open var phone: String? = null

    @NotNull
    @ColumnDefault("now()")
    @Column(name = "last_update", nullable = false)
    open var lastUpdate: Instant? = null
}