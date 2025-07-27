package de.sambalmueslie.gschwind.core.wrapper

import de.sambalmueslie.gschwind.core.api.Sink
import de.sambalmueslie.gschwind.core.api.StreamElement

class SinkWrapper<T>(
    override val id: String,
    override val name: String,
    private val sink: Sink<T>
) : Sink<T>, StreamElement {

    override fun receive(value: T) {
        sink.receive(value)
    }

}