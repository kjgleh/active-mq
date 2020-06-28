package com.example.subscriber01

import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component

@Component
class DefaultSubscriber {

    @JmsListener(destination = "Consumer.subscriber01.VirtualTopic.temp")
    fun subscribe01(message: String) {
        println("@@@@ subscribe01-01 @@@")
        println(message)
    }

    @JmsListener(destination = "Consumer.subscriber01.VirtualTopic.temp")
    fun subscribe02(message: String) {
        println("@@@@ subscribe01-02 @@@")
        println(message)
    }
}