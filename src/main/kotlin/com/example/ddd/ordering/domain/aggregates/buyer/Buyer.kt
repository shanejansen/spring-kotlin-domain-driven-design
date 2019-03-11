package com.example.ddd.ordering.domain.aggregates.buyer

import com.example.ddd.common.AggregateRoot
import com.example.ddd.ordering.domain.events.BuyerCreatedEvent

class Buyer(var id: BuyerId,
            val name: Name,
            val email: Email) : AggregateRoot() {
    constructor(name: Name, email: Email) : this(BuyerId(), name, email) {
        addDomainEvent(BuyerCreatedEvent(this, this))
    }
}
