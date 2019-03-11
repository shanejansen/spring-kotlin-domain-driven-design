package com.example.ddd.common

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.support.TransactionTemplate

abstract class CommandHandler<T, D> {
    @Autowired
    private lateinit var domainEventDispatcher: DomainEventDispatcher
    @Autowired
    private lateinit var transactionTemplate: TransactionTemplate

    protected abstract fun process(command: T): CommandHandlerResult<D>

    fun handle(command: T): CommandHandlerResult<D> {
        return transactionTemplate.execute {
            val result = process(command)
            if (result.hasErrors()) it.setRollbackOnly()
            result
        }!!
    }

    protected fun dispatchDomainEvents(domainEvents: List<IDomainEvent>): ErrorCollection {
        return domainEventDispatcher.dispatch(domainEvents)
    }
}
