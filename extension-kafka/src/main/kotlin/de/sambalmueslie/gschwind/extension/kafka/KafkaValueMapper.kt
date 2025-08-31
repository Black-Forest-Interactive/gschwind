package de.sambalmueslie.gschwind.extension.kafka

interface KafkaValueMapper<T, V> {
    fun serialize(value: T): V
    fun deserialize(value: V): T?
}