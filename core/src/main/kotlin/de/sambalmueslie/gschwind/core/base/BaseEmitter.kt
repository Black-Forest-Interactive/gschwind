package de.sambalmueslie.gschwind.core.base

import de.sambalmueslie.gschwind.core.api.Emitter
import de.sambalmueslie.gschwind.core.api.Receiver

abstract class BaseEmitter<T> : Emitter<T> {
    private var receiver = mutableSetOf<Receiver<T>>()

    override fun emit(value: T) {
        receiver.forEach { r -> r.receive(value) }
    }

    override fun connect(receiver: Receiver<T>) {
        this.receiver.add(receiver)
    }
}