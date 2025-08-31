package de.sambalmueslie.gschwind.extension.kafka

import de.sambalmueslie.gschwind.core.builder.StreamBuilder
import de.sambalmueslie.gschwind.core.builder.generateId
import java.util.*

fun <T, K, V> StreamBuilder<T>.kSink(
    id: String = generateId(),
    name: String = "",
    topic: String,
    keyMapper: KafkaKeyMapper<T, K>,
    valueMapper: KafkaValueMapper<T, V>,
    properties: Properties
): StreamBuilder<T> {
    return sink(id, name) { KafkaSink(topic, keyMapper, valueMapper, properties) }
}