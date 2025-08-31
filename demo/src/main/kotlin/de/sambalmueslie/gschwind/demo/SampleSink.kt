package de.sambalmueslie.gschwind.demo

import de.sambalmueslie.gschwind.core.api.Sink
import org.slf4j.LoggerFactory

class SampleSink : Sink<String> {

    companion object {
        private val logger = LoggerFactory.getLogger(SampleSink::class.java)
    }

    override fun receive(value: String) {
        logger.info("Received $value")
    }
}