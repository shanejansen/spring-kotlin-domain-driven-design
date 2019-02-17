package com.example.ddd.ordering.domain.buyer

import com.example.ddd.common.IRepository

interface IBuyerRepository : IRepository<Buyer> {
    fun existsWithEmail(email: String): Boolean
    fun save(buyer: Buyer)
    fun update(buyer: Buyer)
}
