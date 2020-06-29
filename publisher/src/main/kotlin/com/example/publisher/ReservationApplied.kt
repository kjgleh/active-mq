package com.example.publisher

import java.util.*

data class ReservationApplied(
    val id: UUID = UUID.randomUUID(),
    val customer: Customer = Customer()
)

data class Customer(
    val name: String = UUID.randomUUID().toString()
)
