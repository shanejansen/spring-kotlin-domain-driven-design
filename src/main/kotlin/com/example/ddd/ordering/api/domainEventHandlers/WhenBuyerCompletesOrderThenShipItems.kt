package com.example.ddd.ordering.api.domainEventHandlers

import com.example.ddd.common.domain.DomainEventHandler
import com.example.ddd.common.errors.ErrorCollection
import com.example.ddd.common.domain.IDomainEvent
import com.example.ddd.ordering.domain.events.BuyerCompletedOrderEvent
import org.springframework.stereotype.Component

@Component
class WhenBuyerCompletesOrderThenShipItems : DomainEventHandler<BuyerCompletedOrderEvent>(BuyerCompletedOrderEvent::class) {
    override fun handleDomainEvent(domainEvent: IDomainEvent): ErrorCollection {
        print(domainEvent)
        return ErrorCollection()
    }
}
