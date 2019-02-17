package com.example.ddd.common

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEventPublisher

abstract class CommandHandler<T> {
    @Autowired
    private lateinit var eventPublisher: ApplicationEventPublisher

    protected abstract fun execute(command: T): List<DomainEvent>

    fun handleCommand(command: T) {
        val domainEvents = execute(command)
        domainEvents.map { eventPublisher.publishEvent(it) }
    }
}
