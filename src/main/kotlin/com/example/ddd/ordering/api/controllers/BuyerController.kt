package com.example.ddd.ordering.api.controllers

import com.example.ddd.common.ErrorCollection
import com.example.ddd.ordering.api.commands.CreateBuyerCommand
import com.example.ddd.ordering.api.commands.CreateBuyerCommandHandler
import com.example.ddd.ordering.api.queries.BuyerQuery
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class BuyerController(val buyerQuery: BuyerQuery,
                      val createBuyerCommandHandler: CreateBuyerCommandHandler) {
    @GetMapping("/buyer/{id}")
    fun getBuyer(@PathVariable("id") id: Int): ResponseEntity<*> {
        val buyer = buyerQuery.getBuyer(id)
        return if (buyer == null) ResponseEntity(ErrorCollection.withError("Buyer could not be found.").toDto(), HttpStatus.NOT_FOUND)
        else ResponseEntity.ok(buyer)
    }

    @PostMapping("/buyer")
    fun createBuyer(@RequestBody createBuyerCommand: CreateBuyerCommand): ResponseEntity<*> {
        val result = createBuyerCommandHandler.createBuyer(createBuyerCommand)
        if (result.hasErrors()) return ResponseEntity(result.errorCollection.toDto(), HttpStatus.BAD_REQUEST)
        return getBuyer(result.value.id)
    }
}
