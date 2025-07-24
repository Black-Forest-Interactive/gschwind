package de.sambalmueslie.gschwind.core.base

import de.sambalmueslie.gschwind.core.api.Operator

abstract class BaseOperator<R, E>(id: String, name: String) : Operator<R, E>, BaseStreamElement(id, name) {
}