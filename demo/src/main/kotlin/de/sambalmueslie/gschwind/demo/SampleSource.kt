package de.sambalmueslie.gschwind.demo

import de.sambalmueslie.gschwind.core.base.BaseSource
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow
import kotlin.system.exitProcess

class SampleSource : BaseSource<Int>() {

    private var counter = 0
    private var job: Job? = null


    @OptIn(DelicateCoroutinesApi::class)
    override fun start() {
        if (job != null) return

        job = GlobalScope.launch {
            flow {
                while (counter < 10) {
                    emit(counter++)
                    delay(1000)
                }
                exitProcess(0)
            }.collect { value -> emit(value) }
        }
    }

    override fun stop() {
        job?.cancel()
        job = null
    }

}