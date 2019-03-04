package com.example.ddd.common.domain

abstract class AggregateRoot {
    private val _domainEvents: MutableList<IDomainEvent> = mutableListOf()
    val domainEvents: List<IDomainEvent> get() = _domainEvents

    fun addDomainEvent(domainEvent: IDomainEvent) {
        _domainEvents.add(domainEvent)
    }

    fun removeDomainEvent(domainEvent: IDomainEvent) {
        _domainEvents.remove(domainEvent)
    }
}
