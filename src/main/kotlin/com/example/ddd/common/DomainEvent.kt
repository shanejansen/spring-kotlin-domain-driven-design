package com.example.ddd.common

import org.springframework.context.ApplicationEvent

abstract class DomainEvent(source: Any) : ApplicationEvent(source)
