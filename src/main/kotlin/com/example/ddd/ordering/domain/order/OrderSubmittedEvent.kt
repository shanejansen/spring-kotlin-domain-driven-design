package com.example.ddd.ordering.domain.order

import com.example.ddd.common.DomainEvent
import com.example.ddd.ordering.domain.buyer.Buyer

data class OrderSubmittedEvent(private val eventSource: Any,
                               val buyer: Buyer,
                               val order: Order) : DomainEvent(eventSource)
