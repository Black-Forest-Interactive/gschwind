package de.sambalmueslie.gschwind.core.builder

import de.sambalmueslie.gschwind.core.api.Source
import de.sambalmueslie.gschwind.core.job.EmitterWrapper
import de.sambalmueslie.gschwind.core.job.SourceWrapper
import de.sambalmueslie.gschwind.core.job.StreamWrapper

internal class SourceStreamBuilder<T>(
    stream: StreamWrapper,
    id: String,
    name: String,
    provider: () -> Source<T>
) : BaseStreamBuilder<T>(stream) {

    private val source = SourceWrapper(id, name.ifBlank { "Source" }, provider.invoke())

    init {
        stream.source(source)
    }

    override fun emitter(): EmitterWrapper<T> {
        return source
    }

}