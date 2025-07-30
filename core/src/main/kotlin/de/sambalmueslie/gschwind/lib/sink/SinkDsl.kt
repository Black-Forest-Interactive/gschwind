package de.sambalmueslie.gschwind.lib.sink

import de.sambalmueslie.gschwind.core.builder.StreamBuilder
import de.sambalmueslie.gschwind.core.builder.generateId

fun <T> StreamBuilder<T>.log(
    id: String = generateId(),
    name: String = ""
): StreamBuilder<T> {
    return sink(id, name) { LogSink(name) }
}