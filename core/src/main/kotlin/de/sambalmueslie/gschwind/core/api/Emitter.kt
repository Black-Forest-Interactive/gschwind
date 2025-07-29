package de.sambalmueslie.gschwind.core.api

interface Emitter<T> {
    fun emit(value: T)
    fun connect(receiver: Receiver<T>)
}