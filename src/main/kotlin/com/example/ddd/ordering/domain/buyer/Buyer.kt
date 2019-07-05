package com.example.ddd.ordering.domain.buyer

import com.example.ddd.common.AggregateRoot

class Buyer(var id: BuyerId,
            val name: Name,
            val email: Email) : AggregateRoot() {
    constructor(name: Name, email: Email) : this(BuyerId(), name, email) {
        addDomainEvent(BuyerCreatedEvent(this, this))
    }
}
