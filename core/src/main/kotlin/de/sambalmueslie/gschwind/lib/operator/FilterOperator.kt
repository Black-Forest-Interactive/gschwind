package de.sambalmueslie.gschwind.lib.operator

import de.sambalmueslie.gschwind.core.base.BaseOperator

class FilterOperator<T>(private val predicate: (T) -> Boolean) : BaseOperator<T, T>() {
    override fun receive(value: T) {
        val match = predicate.invoke(value)
        if (match) emit(value)
    }
}