package de.sambalmueslie.gschwind.core.api

data class Stream(
    private var source: Source,
    private val operators: List<Operator>,
    private var sink: Sink,
) {

}