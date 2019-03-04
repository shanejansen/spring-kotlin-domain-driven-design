package com.example.ddd.common.errors

class ErrorCollection(private val errors: MutableList<Error> = mutableListOf()) {
    companion object {
        fun withError(message: String): ErrorCollection {
            val errorCollection = ErrorCollection()
            errorCollection.addError(Error(message))
            return errorCollection
        }
    }

    fun addError(error: Error) = errors.add(error)

    fun combine(other: ErrorCollection) = errors.addAll(other.errors)

    fun hasErrors(): Boolean = !errors.isEmpty()

    fun toDto() = ErrorCollectionDto(errors.map { it.toDto() })
}
