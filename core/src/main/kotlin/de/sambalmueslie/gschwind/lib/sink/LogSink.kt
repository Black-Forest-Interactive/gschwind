package de.sambalmueslie.gschwind.lib.sink

import de.sambalmueslie.gschwind.core.base.BaseSink
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class LogSink<T>(
    name: String = LogSink::class.java.simpleName,
) : BaseSink<T>() {
    private val logger: Logger = LoggerFactory.getLogger(name)
    override fun receive(value: T) {
        logger.info("Received: $value")
    }
}