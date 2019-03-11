package com.example.ddd.ordering.domain.events

import com.example.ddd.common.IDomainEvent
import com.example.ddd.ordering.domain.aggregates.buyer.Buyer
import com.example.ddd.ordering.domain.aggregates.order.Order

data class BuyerCompletedOrderEvent(private val eventSource: Any,
                                    val buyer: Buyer,
                                    val order: Order) : IDomainEvent
