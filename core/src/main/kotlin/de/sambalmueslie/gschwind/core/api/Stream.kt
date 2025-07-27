package de.sambalmueslie.gschwind.core.api

interface Stream {
    val id: String
    fun print()
    fun start()
    fun stop()
}