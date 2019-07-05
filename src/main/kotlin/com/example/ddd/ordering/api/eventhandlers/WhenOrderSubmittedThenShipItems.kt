package com.example.ddd.ordering.api.eventhandlers

import com.example.ddd.common.IDomainEventHandler
import com.example.ddd.ordering.domain.order.OrderSubmittedEvent
import org.springframework.stereotype.Component

@Component
class WhenOrderSubmittedThenShipItems : IDomainEventHandler<OrderSubmittedEvent> {
    override fun onApplicationEvent(domainEvent: OrderSubmittedEvent) {
        print(domainEvent)
        // Issue new command or message
    }
}
