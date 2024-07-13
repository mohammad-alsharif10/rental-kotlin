package com.learning.rentalkotlin.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.time.Instant

@Entity
@Table(name = "staff", schema = "public")
open class Staff {
    @Id
    @ColumnDefault("nextval('staff_staff_id_seq'::regclass)")
    @Column(name = "staff_id", nullable = false)
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
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "address_id", nullable = false)
    open var address: Address? = null

    @Size(max = 50)
    @Column(name = "email", length = 50)
    open var email: String? = null

    @NotNull
    @Column(name = "store_id", nullable = false)
    open var storeId: Short? = null

    @NotNull
    @ColumnDefault("true")
    @Column(name = "active", nullable = false)
    open var active: Boolean? = false

    @Size(max = 16)
    @NotNull
    @Column(name = "username", nullable = false, length = 16)
    open var username: String? = null

    @Size(max = 40)
    @Column(name = "password", length = 40)
    open var password: String? = null

    @NotNull
    @ColumnDefault("now()")
    @Column(name = "last_update", nullable = false)
    open var lastUpdate: Instant? = null

    @Column(name = "picture")
    open var picture: ByteArray? = null
}