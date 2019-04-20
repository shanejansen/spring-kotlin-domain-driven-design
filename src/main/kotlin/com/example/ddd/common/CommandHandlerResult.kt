package com.example.ddd.common

data class CommandHandlerResult<T>(var value: T, var errorCollection: ErrorCollection = ErrorCollection()) {
    fun hasErrors() = errorCollection.hasErrors()
}
