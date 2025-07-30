package de.sambalmueslie.gschwind.lib.operator

import de.sambalmueslie.gschwind.core.base.BaseOperator

class MapNotNullOperator<R, E>(private val transform: (R) -> E?) : BaseOperator<R, E>() {
    override fun receive(value: R) {
        val result: E = transform.invoke(value) ?: return
        emit(result)
    }
}