package de.sambalmueslie.gschwind.demo

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import de.sambalmueslie.gschwind.core.builder.stream
import de.sambalmueslie.gschwind.extension.kafka.JacksonKafkaValueSerializer
import de.sambalmueslie.gschwind.extension.kafka.KafkaKeyMapper
import de.sambalmueslie.gschwind.extension.kafka.KafkaSource
import de.sambalmueslie.gschwind.extension.kafka.kSink
import de.sambalmueslie.gschwind.lib.operator.filter
import de.sambalmueslie.gschwind.lib.operator.map
import de.sambalmueslie.gschwind.lib.sink.log
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.producer.ProducerConfig
import org.slf4j.LoggerFactory
import java.lang.Thread.sleep
import java.util.*

class SampleKafkaApp {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val sample = SampleKafkaApp()
            sample.run()
        }
    }

    fun run() {
        val props = Properties().apply {
            put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
            put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
            put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
            put(
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer"
            )
            put(
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer"
            )
            put(ConsumerConfig.GROUP_ID_CONFIG, "sample-app-group")
            put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")
        }
        val mapper = ObjectMapper().registerModule(KotlinModule.Builder().build())

        val source = SampleSource()
        val s1 = source.stream()
            .map { it.toHexString() }
            .filter { it.startsWith("0000") }
            .kSink(
                topic = "evt.sample.all",
                keyMapper = KafkaKeyMapper() { "all" },
                valueMapper = JacksonKafkaValueSerializer(mapper, String::class.java),
                properties = props
            )
            .build()


        val kafkaSource = KafkaSource<String, String, String>(
            topic = "evt.sample.all",
            valueMapper = JacksonKafkaValueSerializer(mapper, String::class.java),
            properties = props
        )
        val s2 = kafkaSource.stream()
            .map { it }
            .log(name = "SECOND")
            .build()

        s1.print()
        s2.print()

        s1.start()
        s2.start()

        val logger = LoggerFactory.getLogger(SampleApp::class.java)
        while (true) {
            val stats = s1.stats
            logger.debug("Received: ${stats.valuesReceived} Sent: ${stats.valuesSent} Error: ${stats.errors}")
            sleep(500)
        }
    }
}