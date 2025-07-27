package de.sambalmueslie.gschwind.core.job

import de.sambalmueslie.gschwind.core.api.Operator
import de.sambalmueslie.gschwind.core.api.Sink
import de.sambalmueslie.gschwind.core.api.Source

class SourceWrapper<T>(private val source: Source<T>, val id: String, val name: String) : Source<T> {
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