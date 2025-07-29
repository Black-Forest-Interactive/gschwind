package de.sambalmueslie.gschwind.core.wrapper

import de.sambalmueslie.gschwind.core.api.Source

class SourceWrapper<T>(
    id: String,
    name: String,
    private val source: Source<T>
) : Source<T>, EmitterWrapper<T>(id, name, source) {


    override fun start() {
        source.start()
    }

    override fun stop() {
        source.stop()
    }

}