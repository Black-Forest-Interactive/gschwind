package de.sambalmueslie.gschwind.lib.operator

import de.sambalmueslie.gschwind.core.builder.StreamBuilder
import de.sambalmueslie.gschwind.core.builder.generateId

fun <R, E> StreamBuilder<R>.map(
    id: String = generateId(),
    name: String = "",
    transform: (R) -> E
): StreamBuilder<E> {
    return operator(id, name) { MapOperator<R, E>(transform) }
}

fun <R, E> StreamBuilder<R>.mapNotNull(
    id: String = generateId(),
    name: String = "",
    transform: (R) -> E?
): StreamBuilder<E> {
    return operator(id, name) { MapNotNullOperator<R, E>(transform) }
}

fun <T> StreamBuilder<T>.filter(
    id: String = generateId(),
    name: String = "",
    predicate: (T) -> Boolean
): StreamBuilder<T> {
    return operator(id, name) { FilterOperator<T>(predicate) }
}

fun <T> StreamBuilder<T>.filterNot(
    id: String = generateId(),
    name: String = "",
    predicate: (T) -> Boolean
): StreamBuilder<T> {
    return operator(id, name) { FilterOperator<T>(predicate) }
}