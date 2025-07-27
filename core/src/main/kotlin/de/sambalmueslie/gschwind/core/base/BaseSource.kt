package de.sambalmueslie.gschwind.core.base

import de.sambalmueslie.gschwind.core.api.Source

abstract class BaseSource<T>(id: String, name: String) : Source<T>, BaseStreamElement(id, name) {
}