package de.sambalmueslie.gschwind.core.api

interface Source<T> : Emitter<T> {
    fun start()
    fun stop()
}