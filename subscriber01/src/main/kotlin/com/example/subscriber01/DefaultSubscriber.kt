package com.example.subscriber01

import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component

@Component
class DefaultSubscriber {

    @JmsListener(destination = "Consumer.kjg.VirtualTopic.temp")
    fun subscribe01(message: String) {
        println("@@@@ subscribe01 @@@")
        println(message)
    }

    @JmsListener(destination = "Consumer.kjg.VirtualTopic.temp")
    fun subscribe02(message: String) {
        println("@@@@ subscribe02 @@@")
        println(message)
    }
}