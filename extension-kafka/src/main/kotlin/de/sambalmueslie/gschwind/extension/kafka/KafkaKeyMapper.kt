package de.sambalmueslie.gschwind.extension.kafka

fun interface KafkaKeyMapper<T, K> {
    fun getKey(value: T): K
}