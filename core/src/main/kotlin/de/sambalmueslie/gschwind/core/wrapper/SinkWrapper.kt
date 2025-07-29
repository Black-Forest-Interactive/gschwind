package de.sambalmueslie.gschwind.core.wrapper

import de.sambalmueslie.gschwind.core.api.Sink

class SinkWrapper<T>(
    id: String,
    name: String,
    private val sink: Sink<T>
) : Sink<T>, StreamElementWrapper(id, name) {

    override fun receive(value: T) {
        try {
            countReceived()
            sink.receive(value)
        } catch (e: Exception) {
            countError()
        }
    }

}