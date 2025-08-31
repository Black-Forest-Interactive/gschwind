package de.sambalmueslie.gschwind.demo

import de.sambalmueslie.gschwind.core.base.BaseOperator

class SampleOperator : BaseOperator<Int, String>() {


    override fun receive(value: Int) {
        emit(value.toHexString())
    }


}