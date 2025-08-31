package de.sambalmueslie.gschwind.extension.kafka

import de.sambalmueslie.gschwind.lib.source.BaseCoroutineSource
import org.apache.kafka.clients.consumer.ConsumerRecords
import org.apache.kafka.clients.consumer.KafkaConsumer
import java.time.Duration
import java.util.*

class KafkaSource<T, K, V>(
    private val topic: String,
    private val valueMapper: KafkaValueMapper<T, V>,
    properties: Properties
) : BaseCoroutineSource<T>() {

    private val consumer = KafkaConsumer<K, V>(properties)

    override fun start() {
        consumer.subscribe(listOf(topic))
        super.start()
    }

    override fun stop() {
        super.stop()
        consumer.close()
    }

    override fun execute(): List<T> {
        val records: ConsumerRecords<K, V> = consumer.poll(Duration.ofMillis(500))
        return records.mapNotNull { valueMapper.deserialize(it.value()) }
    }
}