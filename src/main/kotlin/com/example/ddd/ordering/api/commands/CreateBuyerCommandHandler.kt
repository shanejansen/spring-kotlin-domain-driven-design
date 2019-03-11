package com.example.ddd.ordering.api.commands

import com.example.ddd.common.CommandHandler
import com.example.ddd.common.CommandHandlerResult
import com.example.ddd.common.ErrorCollection
import com.example.ddd.ordering.domain.aggregates.buyer.*
import org.springframework.stereotype.Service

@Service
class CreateBuyerCommandHandler(private val buyerRepository: IBuyerRepository) : CommandHandler<CreateBuyerCommand, BuyerId>() {
    override fun process(command: CreateBuyerCommand): CommandHandlerResult<BuyerId> {
        if (buyerRepository.existsWithEmail(command.email)) {
            return CommandHandlerResult(
                    value = BuyerId(),
                    errorCollection = ErrorCollection.withError("This email has already been registered."))
        }
        val buyer = Buyer(
                name = Name(command.firstName, command.lastName),
                email = Email(command.email))
        buyerRepository.save(buyer)

        return CommandHandlerResult(value = buyer.id,
                errorCollection = dispatchDomainEvents(buyer.domainEvents))
    }
}
