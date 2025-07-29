package de.sambalmueslie.gschwind.core.wrapper

import de.sambalmueslie.gschwind.core.api.StreamElement

abstract class StreamElementWrapper(
    override val id: String,
    override val name: String,
) : StreamElement {
    override val stats = StreamElementStatsWrapper(0, 0, 0)

    private val listeners = mutableSetOf<StreamElementWrapperStatsListener>()
    fun register(listener: StreamElementWrapperStatsListener) {
        listeners.add(listener)
    }

    fun unregister(listener: StreamElementWrapperStatsListener) {
        listeners.remove(listener)
    }

    protected fun countReceived() {
        stats.valuesReceived++
        listeners.forEach { it.handleReceived() }
    }

    protected fun countSent() {
        stats.valuesSent++
        listeners.forEach { it.handleSent() }
    }

    protected fun countError() {
        stats.errors++
        listeners.forEach { it.handleError() }
    }
}