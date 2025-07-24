package de.sambalmueslie.gschwind.core.api

interface Emitter<T> : StreamElement {
    fun connect(sink: Sink<T>): Sink<T>
    fun <S> operator(operator: Operator<T, S>): Operator<T, S>
}