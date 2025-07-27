package de.sambalmueslie.gschwind.core.builder

import de.sambalmueslie.gschwind.core.wrapper.EmitterWrapper
import de.sambalmueslie.gschwind.core.wrapper.StreamWrapper

internal class SinkStreamBuilder<T>(
    stream: StreamWrapper,
    private val emitter: EmitterWrapper<T>
) : BaseStreamBuilder<T>(stream) {

    override fun emitter(): EmitterWrapper<T> {
        return emitter
    }
}
