package de.sambalmueslie.gschwind.core.wrapper

import de.sambalmueslie.gschwind.core.api.Operator

class OperatorWrapper<R, E>(
    id: String,
    name: String,
    private val operator: Operator<R, E>
) : Operator<R, E>, EmitterWrapper<E>(id, name, operator) {
    override fun receive(value: R) {
        operator.receive(value)
    }

}