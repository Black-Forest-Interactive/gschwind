package de.sambalmueslie.gschwind.core.wrapper

import de.sambalmueslie.gschwind.core.api.StreamElementStats

data class StreamElementStatsWrapper(
    override var valuesReceived: Long = 0,
    override var valuesSent: Long = 0,
    override var errors: Int = 0,
) : StreamElementStats
