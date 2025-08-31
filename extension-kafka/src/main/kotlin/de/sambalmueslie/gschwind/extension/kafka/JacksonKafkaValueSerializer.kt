package de.sambalmueslie.gschwind.extension.kafka

import com.fasterxml.jackson.databind.ObjectMapper

class JacksonKafkaValueSerializer<T>(
    private val mapper: ObjectMapper,
    private val type: Class<T>,
) : KafkaValueMapper<T, String> {

    override fun serialize(value: T): String {
        return mapper.writeValueAsString(value)
    }

    override fun deserialize(value: String): T? {
        return mapper.readValue(value, type)
    }

}