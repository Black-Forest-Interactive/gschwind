package de.sambalmueslie.gschwind.core.job

import de.sambalmueslie.gschwind.core.api.Emitter
import de.sambalmueslie.gschwind.core.api.StreamElement

abstract class EmitterWrapper<T>(
    override val id: String,
    override val name: String,
) : Emitter<T>, StreamElement {
}