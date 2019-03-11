package com.example.ddd.common

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEventPublisher

abstract class CommandHandler {
    @Autowired
    private lateinit var eventPublisher: ApplicationEventPublisher

    protected fun publishDomainEvents(domainEvents: List<DomainEvent>) {
        domainEvents.map { eventPublisher.publishEvent(it) }
    }
}
