package com.example.ddd.ordering.api.domainEventHandlers

import com.example.ddd.common.IDomainEventHandler
import com.example.ddd.ordering.domain.events.BuyerCreatedEvent
import org.springframework.stereotype.Component

@Component
class WhenBuyerCreatedThenSendWelcomeEmail : IDomainEventHandler<BuyerCreatedEvent> {
    override fun onApplicationEvent(event: BuyerCreatedEvent) {
        print("Send email to welcome the new buyer: $event")
    }
}
