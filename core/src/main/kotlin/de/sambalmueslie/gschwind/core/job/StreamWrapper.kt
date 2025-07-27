package de.sambalmueslie.gschwind.core.job

import de.sambalmueslie.gschwind.core.api.Source
import de.sambalmueslie.gschwind.core.api.Stream

class StreamWrapper<T>(
    override val id: String,
    override val name: String,
    private val source: Source<T>
) : Stream {
}