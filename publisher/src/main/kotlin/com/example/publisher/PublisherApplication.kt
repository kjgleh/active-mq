package com.example.publisher

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.jms.support.converter.MappingJackson2MessageConverter
import org.springframework.jms.support.converter.MessageConverter
import org.springframework.jms.support.converter.MessageType

@SpringBootApplication
class PublisherApplication {

    @Bean
    fun jacksonJmsMessageConverter(): MessageConverter {
        val mappingJackson2MessageConverter = MappingJackson2MessageConverter()
        return mappingJackson2MessageConverter.apply {
            setObjectMapper(
                jacksonObjectMapper().apply {
                    configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false)
                    configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                    registerModule(JavaTimeModule())
                    registerModule(KotlinModule())
                }
            )
            setTargetType(MessageType.TEXT)
            setTypeIdPropertyName("_type")
        }
    }
}

fun main(args: Array<String>) {
    runApplication<PublisherApplication>(*args)
}
