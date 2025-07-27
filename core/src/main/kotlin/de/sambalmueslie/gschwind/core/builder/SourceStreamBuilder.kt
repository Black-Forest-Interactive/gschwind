package de.sambalmueslie.gschwind.core.builder

import de.sambalmueslie.gschwind.core.api.Operator
import de.sambalmueslie.gschwind.core.api.Sink
import de.sambalmueslie.gschwind.core.api.Source
import de.sambalmueslie.gschwind.core.job.OperatorWrapper
import de.sambalmueslie.gschwind.core.job.SinkWrapper
import de.sambalmueslie.gschwind.core.job.SourceWrapper

class SourceStreamBuilder<T>(
    id: String,
    name: String,
    provider: () -> Source<T>
) : StreamBuilder<T> {

    private var source: Source<T> = SourceWrapper(provider.invoke(), id, name)

    override fun <E> operator(
        id: String,
        name: String,
        provider: () -> Operator<T, E>
    ): StreamBuilder<E> {
        val operator = OperatorWrapper(provider.invoke(), id, name)
        source.operator(operator)
        return OperatorStreamBuilder(operator)
    }

    override fun sink(
        id: String,
        name: String,
        provider: () -> Sink<T>
    ): StreamBuilder<T> {
        val sink = SinkWrapper(provider.invoke(), id, name)
        source.connect(sink)
        return SinkStreamBuilder(source)
    }


}