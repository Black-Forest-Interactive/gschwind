package de.sambalmueslie.gschwind.core.base

import de.sambalmueslie.gschwind.core.api.Sink

abstract class BaseSink<T>(id: String, name: String) : Sink<T>, BaseStreamElement(id, name) {
}