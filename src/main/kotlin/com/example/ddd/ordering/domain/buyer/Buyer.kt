package com.example.ddd.ordering.domain.buyer

import com.example.ddd.common.AggregateRoot
import com.example.ddd.ordering.domain.events.BuyerCreatedEvent

class Buyer(var id: Int,
            val name: Name,
            val email: String) : AggregateRoot() {
    constructor(name: Name, email: String) : this(0, name, email) {
        addDomainEvent(BuyerCreatedEvent(this, this))
    }
}
