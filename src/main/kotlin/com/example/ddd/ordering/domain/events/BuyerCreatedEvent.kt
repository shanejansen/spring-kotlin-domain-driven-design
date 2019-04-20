package com.example.ddd.ordering.domain.events

import com.example.ddd.common.DomainEvent
import com.example.ddd.ordering.domain.aggregates.buyer.Buyer

data class BuyerCreatedEvent(private val eventSource: Any,
                             val buyer: Buyer) : DomainEvent(eventSource)
