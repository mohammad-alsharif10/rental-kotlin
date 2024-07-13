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
@Table(name = "category", schema = "public")
open class Category {
    @Id
    @ColumnDefault("nextval('category_category_id_seq'::regclass)")
    @Column(name = "category_id", nullable = false)
    open var id: Int? = null

    @Size(max = 25)
    @NotNull
    @Column(name = "name", nullable = false, length = 25)
    open var name: String? = null

    @NotNull
    @ColumnDefault("now()")
    @Column(name = "last_update", nullable = false)
    open var lastUpdate: Instant? = null
}