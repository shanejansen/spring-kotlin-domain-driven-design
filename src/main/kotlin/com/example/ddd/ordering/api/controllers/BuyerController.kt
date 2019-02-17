package com.example.ddd.ordering.api.controllers

import com.example.ddd.ordering.api.commands.CreateBuyerCommand
import com.example.ddd.ordering.api.commands.CreateBuyerCommandHandler
import com.example.ddd.ordering.api.queries.BuyerQuery
import com.example.ddd.ordering.api.viewmodels.BuyerViewModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BuyerController(val buyerQuery: BuyerQuery,
                      val createBuyerCommandHandler: CreateBuyerCommandHandler) {
    @GetMapping("/buyer")
    fun getAllBuyers(): List<BuyerViewModel> {
        return buyerQuery.getAllBuyers()
    }

    @PostMapping("/buyer")
    fun createBuyer(@RequestBody createBuyerCommand: CreateBuyerCommand) {
        createBuyerCommandHandler.handleCommand(createBuyerCommand)
    }
}
