package de.sambalmueslie.gschwind.demo

import de.sambalmueslie.gschwind.core.builder.stream

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
    }
}