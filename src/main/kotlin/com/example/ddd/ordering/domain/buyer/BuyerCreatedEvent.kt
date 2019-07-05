package com.example.ddd.ordering.domain.buyer

import com.example.ddd.common.DomainEvent

data class BuyerCreatedEvent(private val eventSource: Any,
                             val buyer: Buyer) : DomainEvent(eventSource)
