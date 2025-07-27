package de.sambalmueslie.gschwind.demo

import de.sambalmueslie.gschwind.core.builder.stream
import de.sambalmueslie.gschwind.core.job.StreamJob

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
        source.stream()
            .operator { SampleOperator() }
            .sink { SampleSink() }


        val job = StreamJob(source)
        job.start()

    }
}