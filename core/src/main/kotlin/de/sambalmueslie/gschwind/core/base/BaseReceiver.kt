package de.sambalmueslie.gschwind.core.base

import de.sambalmueslie.gschwind.core.api.Receiver

abstract class BaseReceiver<T>(id: String, name: String) : Receiver<T>, BaseStreamElement(id, name) {
}