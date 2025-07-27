package de.sambalmueslie.gschwind.core.builder

import de.sambalmueslie.gschwind.core.api.Source
import de.sambalmueslie.gschwind.core.wrapper.StreamWrapper
import java.util.*


fun <T> Source<T>.stream(id: String = generateId(), name: String = ""): StreamBuilder<T> {
    val stream = StreamWrapper(generateId())
    return SourceStreamBuilder(stream, id, name) { this }
}

fun generateId(): String {
    return UUID.randomUUID().toString().lowercase()
}