package com.example.subscriber01

import java.util.*

data class ReservationApplied(
    val id: UUID = UUID.randomUUID(),
    val customer: Customer = Customer()
)

data class Customer(
    val name: String = UUID.randomUUID().toString(),
    val mobile: String = UUID.randomUUID().toString()
)
