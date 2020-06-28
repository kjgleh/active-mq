package com.example.subscriber02

import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component

@Component
class DefaultPublisher {

    @JmsListener(destination = "Consumer.subscriber02.VirtualTopic.temp")
    fun publish(message: String) {
        throw Exception()
        println("@@@@ subscriber02 @@@@")
        println(message)
    }
}