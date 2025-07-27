package de.sambalmueslie.gschwind.demo

import de.sambalmueslie.gschwind.core.api.Operator
import de.sambalmueslie.gschwind.core.api.Receiver
import de.sambalmueslie.gschwind.core.api.Sink

class SampleOperator : Operator<Int, String> {

    private var receiver: Receiver<String>? = null

    override fun receive(value: Int) {
        receiver?.receive(value.toHexString())
    }

    override fun connect(sink: Sink<String>): Sink<String> {
        receiver = sink
        return sink
    }

    override fun <S> operator(operator: Operator<String, S>): Operator<String, S> {
        receiver = operator
        return operator
    }

}