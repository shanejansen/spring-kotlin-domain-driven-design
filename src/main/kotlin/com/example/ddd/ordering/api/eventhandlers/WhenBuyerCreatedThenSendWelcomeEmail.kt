package com.example.ddd.ordering.api.eventhandlers

import com.example.ddd.common.IDomainEventHandler
import com.example.ddd.ordering.domain.buyer.BuyerCreatedEvent
import org.springframework.stereotype.Component

@Component
class WhenBuyerCreatedThenSendWelcomeEmail : IDomainEventHandler<BuyerCreatedEvent> {
    override fun onApplicationEvent(domainEvent: BuyerCreatedEvent) {
        print(domainEvent)
        // Issue new command or message
    }
}
