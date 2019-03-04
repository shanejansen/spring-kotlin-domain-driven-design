package com.example.ddd.ordering.domain.aggregates.buyer

import com.example.ddd.common.domain.IRepository

interface IBuyerRepository : IRepository<Buyer> {
    fun existsWithEmail(email: String): Boolean
    fun save(buyer: Buyer)
    fun update(buyer: Buyer)
}
