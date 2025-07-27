package de.sambalmueslie.gschwind.core.job

import de.sambalmueslie.gschwind.core.api.Operator
import de.sambalmueslie.gschwind.core.api.Sink

class OperatorWrapper<R, E>(private val operator: Operator<R, E>, val id: String, val name: String) : Operator<R, E> {
    override fun connect(sink: Sink<E>): Sink<E> {
        return operator.connect(sink)
    }

    override fun <S> operator(operator: Operator<E, S>): Operator<E, S> {
        return this.operator.operator(operator)
    }

    override fun receive(value: R) {
        return operator.receive(value)
    }
}