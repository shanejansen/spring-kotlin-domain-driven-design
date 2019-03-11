package com.example.ddd.common

import org.springframework.context.ApplicationEvent
import org.springframework.context.ApplicationListener

interface IDomainEventHandler<T : ApplicationEvent> : ApplicationListener<T>
