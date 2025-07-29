package de.sambalmueslie.gschwind.core.base

import de.sambalmueslie.gschwind.core.api.Source

abstract class BaseSource<T> : Source<T>, BaseEmitter<T>() {
}