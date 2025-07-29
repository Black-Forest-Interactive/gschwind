package de.sambalmueslie.gschwind.core.wrapper

import de.sambalmueslie.gschwind.core.api.Emitter
import de.sambalmueslie.gschwind.core.api.Receiver

abstract class EmitterWrapper<T>(
    id: String,
    name: String,
    val emitter: Emitter<T>
) : Emitter<T>, StreamElementWrapper(id, name) {


    override fun emit(value: T) {
        try {
            emitter.emit(value)
            countSent()
        } catch (e: Exception) {
            countError()
        }
    }

    override fun connect(receiver: Receiver<T>) {
        val wrapper = ReceiverWrapper(receiver, this)
        emitter.connect(wrapper)
    }

    private class ReceiverWrapper<T>(private val receiver: Receiver<T>, private val emitterWrapper: EmitterWrapper<T>) :
        Receiver<T> {
        override fun receive(value: T) {
            emitterWrapper.countSent()
            receiver.receive(value)
        }

    }
}
