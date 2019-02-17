package com.example.ddd.common

abstract class AggregateRoot {
    private val _domainEvents: MutableList<DomainEvent> = mutableListOf()
    val domainEvents: List<DomainEvent> get() = _domainEvents

    fun addDomainEvent(domainEvent: DomainEvent) {
        _domainEvents.add(domainEvent)
    }

    fun removeDomainEvent(domainEvent: DomainEvent) {
        _domainEvents.remove(domainEvent)
    }
}
