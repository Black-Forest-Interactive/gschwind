package de.sambalmueslie.gschwind.core.api

interface Stream {
    val id: String
    val stats: StreamElementStats

    fun print()

    fun start()
    fun stop()

}