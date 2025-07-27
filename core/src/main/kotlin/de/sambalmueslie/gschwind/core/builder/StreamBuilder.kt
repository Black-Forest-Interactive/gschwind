package de.sambalmueslie.gschwind.core.builder

import de.sambalmueslie.gschwind.core.api.Operator
import de.sambalmueslie.gschwind.core.api.Sink
import de.sambalmueslie.gschwind.core.api.Stream


interface StreamBuilder<T> {
    fun <E> operator(id: String = generateId(), name: String = "", provider: () -> Operator<T, E>): StreamBuilder<E>
    fun sink(id: String = generateId(), name: String = "", provider: () -> Sink<T>): StreamBuilder<T>
    fun build(): Stream
}
