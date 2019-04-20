package com.example.ddd.ordering.api.domainEventHandlers

import com.example.ddd.common.IDomainEventHandler
import com.example.ddd.ordering.domain.events.BuyerCompletedOrderEvent
import org.springframework.stereotype.Component

@Component
class WhenBuyerCompletesOrderThenShipItems : IDomainEventHandler<BuyerCompletedOrderEvent> {
    override fun onApplicationEvent(domainEvent: BuyerCompletedOrderEvent) {
        print(domainEvent)
    }
}
