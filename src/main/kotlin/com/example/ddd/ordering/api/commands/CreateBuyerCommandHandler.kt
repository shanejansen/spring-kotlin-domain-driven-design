package com.example.ddd.ordering.api.commands

import com.example.ddd.common.CommandHandler
import com.example.ddd.common.DomainEvent
import com.example.ddd.ordering.domain.buyer.Buyer
import com.example.ddd.ordering.domain.buyer.IBuyerRepository
import com.example.ddd.ordering.domain.buyer.Name
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class CreateBuyerCommandHandler(private val buyerRepository: IBuyerRepository) : CommandHandler<CreateBuyerCommand>() {
    override fun execute(command: CreateBuyerCommand): List<DomainEvent> {
        if (buyerRepository.existsWithEmail(command.email)) {
            // TODO: Implement error handling
            throw RuntimeException("Email already exists")
        }
        val buyer = Buyer(name = Name(command.firstName, command.lastName), email = command.email)
        buyerRepository.save(buyer)
        return buyer.domainEvents
    }
}
