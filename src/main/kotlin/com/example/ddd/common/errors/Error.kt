package com.example.ddd.common.errors

class Error(private val message: String) {
    fun toDto() = ErrorDto(message)
}
