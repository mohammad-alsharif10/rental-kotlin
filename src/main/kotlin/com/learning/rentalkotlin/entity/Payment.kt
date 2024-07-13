package com.learning.rentalkotlin.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.math.BigDecimal
import java.time.Instant

@Entity
@Table(
    name = "payment", schema = "public", indexes = [
        Index(name = "idx_fk_customer_id", columnList = "customer_id"),
        Index(name = "idx_fk_staff_id", columnList = "staff_id"),
        Index(name = "idx_fk_rental_id", columnList = "rental_id")
    ]
)
open class Payment {
    @Id
    @ColumnDefault("nextval('payment_payment_id_seq'::regclass)")
    @Column(name = "payment_id", nullable = false)
    open var id: Int? = null

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "customer_id", nullable = false)
    open var customer: Customer? = null

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "staff_id", nullable = false)
    open var staff: com.learning.rentalkotlin.entity.Staff? = null

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "rental_id", nullable = false)
    open var rental: com.learning.rentalkotlin.entity.Rental? = null

    @NotNull
    @Column(name = "amount", nullable = false, precision = 5, scale = 2)
    open var amount: BigDecimal? = null

    @NotNull
    @Column(name = "payment_date", nullable = false)
    open var paymentDate: Instant? = null
}