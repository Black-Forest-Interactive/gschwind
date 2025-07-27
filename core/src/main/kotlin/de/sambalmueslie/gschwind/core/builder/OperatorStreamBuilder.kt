package de.sambalmueslie.gschwind.core.builder

import de.sambalmueslie.gschwind.core.job.EmitterWrapper
import de.sambalmueslie.gschwind.core.job.OperatorWrapper
import de.sambalmueslie.gschwind.core.job.StreamWrapper

internal class OperatorStreamBuilder<R, E>(
    stream: StreamWrapper,
    private val operator: OperatorWrapper<R, E>
) : BaseStreamBuilder<E>(stream) {

    override fun emitter(): EmitterWrapper<E> {
        return operator
    }

}