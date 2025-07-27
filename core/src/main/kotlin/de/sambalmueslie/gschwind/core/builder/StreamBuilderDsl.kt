package de.sambalmueslie.gschwind.core.builder

import de.sambalmueslie.gschwind.core.api.Source
import java.util.*


fun <T> Source<T>.stream(id: String = generateId(), name: String = ""): StreamBuilder<T> {
    return SourceStreamBuilder(id, name) { this }
}

fun generateId(): String {
    return UUID.randomUUID().toString().lowercase()
}