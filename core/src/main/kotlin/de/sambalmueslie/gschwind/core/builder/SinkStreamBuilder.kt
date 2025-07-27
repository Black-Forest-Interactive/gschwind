package de.sambalmueslie.gschwind.core.builder

import de.sambalmueslie.gschwind.core.job.EmitterWrapper
import de.sambalmueslie.gschwind.core.job.StreamWrapper

internal class SinkStreamBuilder<T>(
    stream: StreamWrapper,
    private val emitter: EmitterWrapper<T>
) : BaseStreamBuilder<T>(stream) {

    override fun emitter(): EmitterWrapper<T> {
        return emitter
    }
}
