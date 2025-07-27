package de.sambalmueslie.gschwind.core.builder

import de.sambalmueslie.gschwind.core.api.Emitter
import de.sambalmueslie.gschwind.core.api.Operator
import de.sambalmueslie.gschwind.core.api.Sink
import de.sambalmueslie.gschwind.core.job.OperatorWrapper
import de.sambalmueslie.gschwind.core.job.SinkWrapper

class SinkStreamBuilder<T>(private val emitter: Emitter<T>) : StreamBuilder<T> {

    override fun <E> operator(
        id: String,
        name: String,
        provider: () -> Operator<T, E>
    ): StreamBuilder<E> {
        val operator = OperatorWrapper(provider.invoke(), id, name)
        emitter.operator(operator)
        return OperatorStreamBuilder(operator)
    }

    override fun sink(
        id: String,
        name: String,
        provider: () -> Sink<T>
    ): StreamBuilder<T> {
        val sink = SinkWrapper(provider.invoke(), id, name)
        emitter.connect(sink)
        return SinkStreamBuilder(emitter)
    }

}
