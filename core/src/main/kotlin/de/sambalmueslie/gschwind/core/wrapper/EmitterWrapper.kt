package de.sambalmueslie.gschwind.core.wrapper

import de.sambalmueslie.gschwind.core.api.Emitter
import de.sambalmueslie.gschwind.core.api.Receiver
import de.sambalmueslie.gschwind.core.api.StreamElement

abstract class EmitterWrapper<T>(
    override val id: String,
    override val name: String,
    val emitter: Emitter<T>
) : Emitter<T>, StreamElement {

    override fun emit(value: T) {
        emitter.emit(value)
    }

    override fun connect(receiver: Receiver<T>) {
        emitter.connect(receiver)
    }

}