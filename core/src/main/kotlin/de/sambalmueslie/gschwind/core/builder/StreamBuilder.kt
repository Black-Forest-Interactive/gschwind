package de.sambalmueslie.gschwind.core.builder

import de.sambalmueslie.gschwind.core.api.Operator
import de.sambalmueslie.gschwind.core.api.Sink
import de.sambalmueslie.gschwind.core.api.Source


interface StreamBuilder<T> {
    fun <E> operator(id: String = generateId(), name: String = "", provider: () -> Operator<T, E>): StreamBuilder<E>
    fun sink(id: String = generateId(), name: String = "", provider: () -> Sink<T>): StreamBuilder<T>

//
//    private var source: Source<T>? = null
//
//    fun source(source: Source<T>, id: String, name: String): StreamBuilder<T> {
//        this.source = SourceWrapper(source, id, name)
//        return StreamBuilder()
//    }
//
//
//    fun <R, E> operator(
//        id: String = generateId(),
//        name: String = "",
//        provider: () -> Operator<R, E>
//    ): StreamBuilder<T> {
//        val operator = OperatorWrapper(provider.invoke(), id, name)
//        return this
//    }
//
//    fun <S> sink(id: String = generateId(), name: String = "", provider: () -> Sink<S>): StreamBuilder<T> {
//        val sink = SinkWrapper(provider.invoke(), id, name)
//        return this
//    }
//
//    fun build(id: String = generateId(), name: String = ""): Stream {
//        val operator = StreamWrapper(id, name, source!!)
//        return operator
//    }

}
