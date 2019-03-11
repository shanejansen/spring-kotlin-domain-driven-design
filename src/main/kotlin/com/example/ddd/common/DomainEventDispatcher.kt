package com.example.ddd.common

import org.springframework.stereotype.Component

@Component
class DomainEventDispatcher(domainEventHandlers: List<DomainEventHandler<*>>) {
    private val domainEventTypeToHandlers = domainEventHandlers.groupBy { it.handledType() }

    fun dispatch(domainEvents: List<IDomainEvent>): ErrorCollection {
        val notificationCollection = ErrorCollection()
        domainEvents.forEach { domainEvent ->
            domainEventTypeToHandlers[domainEvent::class].orEmpty()
                    .forEach {
                        val newNotifications = it.handleDomainEvent(domainEvent)
                        notificationCollection.combine(newNotifications)
                    }
        }
        return notificationCollection
    }
}
