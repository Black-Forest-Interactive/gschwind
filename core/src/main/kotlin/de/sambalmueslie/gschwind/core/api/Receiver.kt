package de.sambalmueslie.gschwind.core.api

interface Receiver<T> : StreamElement {
    fun receive(value: T)
}