package de.sambalmueslie.gschwind.core.job

import de.sambalmueslie.gschwind.core.api.Source

class StreamJob<T>(
    private val source: Source<T>,
) {

    fun start() {
        source.start()
    }

}