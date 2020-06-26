package com.example.subscriber01

import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component

@Component
class DefaultSubscriber {

    @JmsListener(destination = "temp")
    fun subscribe01(message: String) {
        println("@@@@ subscribe01 @@@")
        println(message)
    }

    @JmsListener(destination = "temp")
    fun subscribe02(message: String) {
        println("@@@@ subscribe02 @@@")
        println(message)
    }
}