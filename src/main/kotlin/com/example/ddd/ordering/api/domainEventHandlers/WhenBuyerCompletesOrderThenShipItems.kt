package com.example.ddd.ordering.api.domainEventHandlers

import com.example.ddd.common.DomainEventHandler
import com.example.ddd.common.ErrorCollection
import com.example.ddd.common.IDomainEvent
import com.example.ddd.ordering.domain.events.BuyerCompletedOrderEvent
import org.springframework.stereotype.Component

@Component
class WhenBuyerCompletesOrderThenShipItems : DomainEventHandler<BuyerCompletedOrderEvent>(BuyerCompletedOrderEvent::class) {
    override fun handleDomainEvent(domainEvent: IDomainEvent): ErrorCollection {
        print(domainEvent)
        return ErrorCollection()
    }
}
