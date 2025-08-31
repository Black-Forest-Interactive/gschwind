package de.sambalmueslie.gschwind.extension.kafka

import de.sambalmueslie.gschwind.core.base.BaseSink
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import java.util.*

class KafkaSink<T, K, V>(
    private val topic: String,
    private val keyMapper: KafkaKeyMapper<T, K>,
    private val valueMapper: KafkaValueMapper<T, V>,
    properties: Properties
) : BaseSink<T>() {

    private val producer = KafkaProducer<K, V>(properties)

    override fun receive(value: T) {
        val key = keyMapper.getKey(value)
        val record = ProducerRecord(topic, key, valueMapper.serialize(value))
        producer.send(record)
    }
}