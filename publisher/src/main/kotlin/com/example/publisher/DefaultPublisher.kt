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

    @GetMapping("/publish/apply")
    fun publishApply() {
        val message = ReservationApplied()
        println("@@@@ publish reservation applied @@@")
        println(message)
        jmsTemplate.convertAndSend("VirtualTopic.Event", message)
    }

    @GetMapping("/publish/confirm")
    fun publishConfirm() {
        val message = ReservationConfirmed(manager = "tester")
        println("@@@@ publish reservation confirmed @@@")
        println(message)
        jmsTemplate.convertAndSend("VirtualTopic.Event", message)
    }
}