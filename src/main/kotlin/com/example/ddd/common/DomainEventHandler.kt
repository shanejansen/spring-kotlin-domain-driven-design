package com.example.ddd.common

import kotlin.reflect.KClass

abstract class DomainEventHandler<T : IDomainEvent>(private var handledType: KClass<T>) {
    abstract fun handleDomainEvent(domainEvent: IDomainEvent): ErrorCollection

    fun handledType(): KClass<T> {
        return handledType
    }
}
