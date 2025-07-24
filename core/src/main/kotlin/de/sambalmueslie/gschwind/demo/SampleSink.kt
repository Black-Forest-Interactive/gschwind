package de.sambalmueslie.gschwind.demo

import de.sambalmueslie.gschwind.core.base.BaseSink
import org.slf4j.LoggerFactory

class SampleSink(id: String, name: String) : BaseSink<String>(id, name) {

    companion object {
        private val logger = LoggerFactory.getLogger(SampleSink::class.java)
    }

    override fun receive(value: String) {
        logger.info("Received $value")
    }
}