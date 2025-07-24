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
        val source = SampleSource("", "Sample-Source")
        source.operator(SampleOperator("", "Sample-Operator"))
            .connect(SampleSink("", "Sample-Sink"))

        val job = StreamJob(source)
        job.start()

    }
}