package com.example.ddd.ordering.domain.buyer

data class Name(val firstName: String, val lastName: String) {
    fun fullName() = "$firstName $lastName"
}
