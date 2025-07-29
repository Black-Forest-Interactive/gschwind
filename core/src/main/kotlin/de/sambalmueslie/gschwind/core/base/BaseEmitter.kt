package de.sambalmueslie.gschwind.core.base

import de.sambalmueslie.gschwind.core.api.Emitter
import de.sambalmueslie.gschwind.core.api.Receiver

abstract class BaseEmitter<T> : Emitter<T> {
    private var receiver: Receiver<T>? = null

    override fun emit(value: T) {
        receiver?.receive(value)
    }

    override fun connect(receiver: Receiver<T>) {
        this.receiver = receiver
    }
}