package com.example.ddd.ordering.api.commands

data class CreateBuyerCommand(val firstName: String,
                              val lastName: String,
                              val email: String)
