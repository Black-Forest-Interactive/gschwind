package de.sambalmueslie.gschwind.lib.operator

import de.sambalmueslie.gschwind.core.base.BaseOperator

class MapOperator<R, E>(private val transform: (R) -> E) : BaseOperator<R, E>() {
    override fun receive(value: R) {
        val result = transform.invoke(value)
        emit(result)
    }
}