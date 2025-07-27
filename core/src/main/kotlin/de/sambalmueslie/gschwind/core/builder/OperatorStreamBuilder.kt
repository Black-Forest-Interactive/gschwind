package de.sambalmueslie.gschwind.core.builder

import de.sambalmueslie.gschwind.core.api.Operator
import de.sambalmueslie.gschwind.core.api.Sink
import de.sambalmueslie.gschwind.core.job.OperatorWrapper
import de.sambalmueslie.gschwind.core.job.SinkWrapper

class OperatorStreamBuilder<R, E>(
    private val operator: OperatorWrapper<R, E>
) : StreamBuilder<E> {

    override fun <T> operator(id: String, name: String, provider: () -> Operator<E, T>): StreamBuilder<T> {
        val operator: OperatorWrapper<E, T> = OperatorWrapper(provider.invoke(), id, name)
        this.operator.operator(operator)
        return OperatorStreamBuilder(operator)
    }

    override fun sink(id: String, name: String, provider: () -> Sink<E>): StreamBuilder<E> {
        val sink = SinkWrapper(provider.invoke(), id, name)
        operator.connect(sink)
        return SinkStreamBuilder(operator)
    }
}