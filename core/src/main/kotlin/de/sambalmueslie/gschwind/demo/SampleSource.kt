package de.sambalmueslie.gschwind.demo

import de.sambalmueslie.gschwind.core.api.Operator
import de.sambalmueslie.gschwind.core.api.Receiver
import de.sambalmueslie.gschwind.core.api.Sink
import de.sambalmueslie.gschwind.core.base.BaseSource
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

class SampleSource(id: String, name: String) : BaseSource<Int>(id, name), Runnable {

    companion object {
        private val pool = Executors.newScheduledThreadPool(1)
    }

    private var counter = 0
    private var receiver: Receiver<Int>? = null
    private var future: ScheduledFuture<*>? = null

    override fun connect(sink: Sink<Int>): Sink<Int> {
        this.receiver = sink
        return sink
    }

    override fun <S> operator(operator: Operator<Int, S>): Operator<Int, S> {
        this.receiver = operator
        return operator
    }

    override fun start() {
        future = pool.scheduleAtFixedRate(this, 0, 1, TimeUnit.SECONDS)
    }

    override fun stop() {
        if (future != null) {
            future!!.cancel(true)
            future = null
        }
    }

    override fun run() {
        receiver?.receive(counter++)
        if (counter >= 10) stop()
    }
}