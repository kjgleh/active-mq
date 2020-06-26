package com.example.publisher

import org.springframework.jms.core.JmsTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class DefaultPublisher(
    private val jmsTemplate: JmsTemplate
) {

    @GetMapping("/publish")
    fun publish() {
        val message = UUID.randomUUID().toString()
        println("@@@@ publish @@@")
        println(message)
        jmsTemplate.convertAndSend("VirtualTopic.temp", message)
    }
}