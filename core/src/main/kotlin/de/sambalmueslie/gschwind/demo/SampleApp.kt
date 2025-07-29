package de.sambalmueslie.gschwind.demo

import de.sambalmueslie.gschwind.core.builder.stream
import org.slf4j.LoggerFactory
import java.lang.Thread.sleep

class SampleApp {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val sample = SampleApp()
            sample.run()
        }
    }

    fun run() {

        val source = SampleSource()
        val stream = source.stream()
            .operator { SampleOperator() }
            .sink { SampleSink() }
            .build()

        stream.print()
        stream.start()

        val logger = LoggerFactory.getLogger(SampleApp::class.java)
        while (true) {
            val stats = stream.stats
            logger.debug("Received: ${stats.valuesReceived} Sent: ${stats.valuesSent} Error: ${stats.errors}")
            sleep(500)
        }
    }
}