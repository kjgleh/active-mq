package com.example.activemq

import org.springframework.jms.annotation.JmsListener
import org.springframework.jms.core.JmsTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SendController(
    private val jmsTemplate: JmsTemplate
) {

    @GetMapping("/send")
    fun send() {
        jmsTemplate.convertAndSend("temp.Topic", "test")
    }

    @JmsListener(destination = "temp.Topic")
    fun listen(message: String) {
        println("@@@@@@")
        println(message)
        println("@@@@@@")
    }
}