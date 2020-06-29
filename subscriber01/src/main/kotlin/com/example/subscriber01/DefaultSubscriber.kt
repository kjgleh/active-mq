package com.example.subscriber01

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.apache.activemq.command.ActiveMQTextMessage
import org.springframework.jms.annotation.JmsListener
import org.springframework.messaging.handler.annotation.Payload
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

    @JmsListener(destination = "Consumer.subscriber01.VirtualTopic.Event", selector = "_type = 'com.example.publisher.ReservationApplied'")
    fun subscribeReservation01(@Payload message: ActiveMQTextMessage) {
        val reservation = jacksonObjectMapper().readValue(message.text, ReservationApplied::class.java)
        println("@@@@ subscribeReservation01 @@@")
        println(reservation)
    }

    @JmsListener(destination = "Consumer.subscriber01.VirtualTopic.Event", selector = "_type LIKE '%ReservationConfirmed'")
    fun subscribeReservation02(@Payload message: ActiveMQTextMessage) {
        val reservation = jacksonObjectMapper().readValue(message.text, ReservationConfirmed::class.java)
        println("@@@@ subscribeReservation02 @@@")
        println(reservation)
    }
}