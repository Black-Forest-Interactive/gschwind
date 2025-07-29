package de.sambalmueslie.gschwind.core.base

import de.sambalmueslie.gschwind.core.api.Operator

abstract class BaseOperator<R, E> : Operator<R, E>, BaseEmitter<E>() {
}