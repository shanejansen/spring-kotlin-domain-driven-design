package com.example.ddd.common.domain

import com.example.ddd.common.errors.ErrorCollection

data class CommandHandlerResult<T>(var value: T, var errorCollection: ErrorCollection = ErrorCollection()) {
    fun hasErrors() = errorCollection.hasErrors()
}
