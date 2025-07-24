package de.sambalmueslie.gschwind.core.api

interface Operator<R, E> : Receiver<R>, Emitter<E>, StreamElement {
}