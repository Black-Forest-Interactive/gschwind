package de.sambalmueslie.gschwind.core.api

interface Receiver<T> {
    fun receive(value: T)
}