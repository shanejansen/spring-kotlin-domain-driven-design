package com.example.ddd.ordering.domain.aggregates.buyer

data class Name(val firstName: String, val lastName: String) {
    fun fullName() = "$firstName $lastName"
}
