package de.sambalmueslie.gschwind.core.wrapper

interface StreamElementWrapperStatsListener {
    fun handleReceived()
    fun handleSent()
    fun handleError()
}