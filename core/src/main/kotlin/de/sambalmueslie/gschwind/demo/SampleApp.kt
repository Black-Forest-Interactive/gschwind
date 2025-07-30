package de.sambalmueslie.gschwind.demo

import de.sambalmueslie.gschwind.core.builder.stream
import de.sambalmueslie.gschwind.lib.operator.filter
import de.sambalmueslie.gschwind.lib.operator.map
import de.sambalmueslie.gschwind.lib.sink.log

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
        val s1 = source.stream()
            .map { it.toHexString() }
            .filter { it.startsWith("0000") }
            .log("All Values")
            .build()

        val s2 = source.stream()
            .filter { it % 2 == 0 }
            .map { it.toHexString() }
            .log("Even Values")
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