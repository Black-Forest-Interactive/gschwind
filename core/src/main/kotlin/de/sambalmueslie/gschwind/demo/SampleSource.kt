package de.sambalmueslie.gschwind.demo

import de.sambalmueslie.gschwind.core.base.BaseSource
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit
import kotlin.system.exitProcess

class SampleSource : BaseSource<Int>(), Runnable {

    companion object {
        private val pool = Executors.newScheduledThreadPool(1)
    }

    private var counter = 0
    private var future: ScheduledFuture<*>? = null


    override fun start() {
        if (future != null) return
        future = pool.scheduleAtFixedRate(this, 0, 1, TimeUnit.SECONDS)
    }

    override fun stop() {
        if (future != null) {
            future!!.cancel(true)
            future = null
        }
    }

    override fun run() {
        emit(counter++)
        if (counter >= 10) exitProcess(0)
    }
}