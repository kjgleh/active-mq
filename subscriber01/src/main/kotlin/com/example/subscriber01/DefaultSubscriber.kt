package com.example.subscriber01

import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component

@Component
class DefaultSubscriber {

    @JmsListener(destination = "temp")
    fun subscribe(message: String) {
        println("@@@@ subscribe @@@")
        println(message)
    }
}