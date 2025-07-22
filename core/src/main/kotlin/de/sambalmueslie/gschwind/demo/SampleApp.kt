package de.sambalmueslie.gschwind.demo

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
        source.operator(SampleOperator())
            .connect(SampleSink())

        val job = StreamJob(source)
        job.start()

    }
}