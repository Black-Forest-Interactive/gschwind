package de.sambalmueslie.gschwind.lib.source

import de.sambalmueslie.gschwind.core.base.BaseSource
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

abstract class BaseCoroutineSource<T> : BaseSource<T>() {

    private var job: Job? = null
    private var running: Boolean = false

    @OptIn(DelicateCoroutinesApi::class)
    override fun start() {
        if (job != null) return
        running = true
        job = GlobalScope.launch {
            flow {
                while (running) {
                    val values = execute()
                    values.forEach { emit(it) }
                }
            }.collect { value -> emit(value) }
        }
    }

    override fun stop() {
        running = false
        job?.cancel()
        job = null
    }

    protected abstract fun execute(): List<T>
}