package de.sambalmueslie.gschwind.core.base

import de.sambalmueslie.gschwind.core.api.Emitter

abstract class BaseEmitter<T>(id: String, name: String) : Emitter<T>, BaseStreamElement(id, name) {
}