package de.sambalmueslie.gschwind.core.job

import de.sambalmueslie.gschwind.core.api.Sink

class SinkWrapper<T>(private val sink: Sink<T>, val id: String, val name: String) : Sink<T> {
    override fun receive(value: T) {
        sink.receive(value)
    }

}