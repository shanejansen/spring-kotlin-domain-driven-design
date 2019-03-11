package com.example.ddd.ordering.api.domainEventHandlers

import com.example.ddd.common.DomainEventHandler
import com.example.ddd.common.ErrorCollection
import com.example.ddd.common.IDomainEvent
import com.example.ddd.ordering.domain.events.BuyerCreatedEvent
import org.springframework.stereotype.Component

@Component
class WhenBuyerCreatedThenSendWelcomeEmail : DomainEventHandler<BuyerCreatedEvent>(BuyerCreatedEvent::class) {
    override fun handleDomainEvent(domainEvent: IDomainEvent): ErrorCollection {
        print("Send email to welcome the new buyer: $domainEvent")
        return ErrorCollection()
    }
}
