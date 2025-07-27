package de.sambalmueslie.gschwind.core.wrapper

import de.sambalmueslie.gschwind.core.api.Operator
import de.sambalmueslie.gschwind.core.api.Sink
import de.sambalmueslie.gschwind.core.api.Source

class SourceWrapper<T>(
    id: String,
    name: String,
    private val source: Source<T>
) : Source<T>, EmitterWrapper<T>(id, name) {

    override fun start() {
        source.start()
    }

    override fun stop() {
        source.stop()
    }

    override fun connect(sink: Sink<T>): Sink<T> {
        return source.connect(sink)
    }

    override fun <S> operator(operator: Operator<T, S>): Operator<T, S> {
        return source.operator(operator)
    }

}