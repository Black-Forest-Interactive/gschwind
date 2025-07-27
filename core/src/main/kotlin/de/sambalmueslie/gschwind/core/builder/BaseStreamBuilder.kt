package de.sambalmueslie.gschwind.core.builder

import de.sambalmueslie.gschwind.core.api.Operator
import de.sambalmueslie.gschwind.core.api.Sink
import de.sambalmueslie.gschwind.core.api.Stream
import de.sambalmueslie.gschwind.core.job.EmitterWrapper
import de.sambalmueslie.gschwind.core.job.OperatorWrapper
import de.sambalmueslie.gschwind.core.job.SinkWrapper
import de.sambalmueslie.gschwind.core.job.StreamWrapper

abstract class BaseStreamBuilder<T>(
    private val stream: StreamWrapper
) : StreamBuilder<T> {

    override fun <E> operator(
        id: String,
        name: String,
        provider: () -> Operator<T, E>
    ): StreamBuilder<E> {
        val operator = OperatorWrapper(id, name.ifBlank { "Operator" }, provider.invoke())
        val emitter = emitter()
        stream.connect(emitter, operator)
        emitter.operator(operator)
        return OperatorStreamBuilder(stream, operator)
    }

    override fun sink(
        id: String,
        name: String,
        provider: () -> Sink<T>
    ): StreamBuilder<T> {
        val sink = SinkWrapper(id, name.ifBlank { "Sink" }, provider.invoke())
        val emitter = emitter()
        stream.connect(emitter, sink)
        emitter.connect(sink)
        return SinkStreamBuilder(stream, emitter)
    }

    override fun build(): Stream {
        return stream
    }


    protected abstract fun emitter(): EmitterWrapper<T>
}