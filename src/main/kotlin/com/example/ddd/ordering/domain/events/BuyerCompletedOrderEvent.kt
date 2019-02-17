package com.example.ddd.ordering.domain.events

import com.example.ddd.common.DomainEvent
import com.example.ddd.ordering.domain.buyer.Buyer
import com.example.ddd.ordering.domain.order.Order

data class BuyerCompletedOrderEvent(private val eventSource: Any,
                                    val buyer: Buyer,
                                    val order: Order) : DomainEvent(eventSource)
