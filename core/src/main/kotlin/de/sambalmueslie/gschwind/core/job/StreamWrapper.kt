package de.sambalmueslie.gschwind.core.job

import de.sambalmueslie.gschwind.core.api.Stream
import de.sambalmueslie.gschwind.core.api.StreamElement

class StreamWrapper(
    override val id: String
) : Stream {

    private val tree = mutableListOf<StreamElementNode>()
    private val nodes = mutableMapOf<String, StreamElementNode>()
    private val sources = mutableListOf<SourceWrapper<*>>()

    fun <T> source(source: SourceWrapper<T>) {
        val node = StreamElementNode(source)
        tree.add(node)
        nodes.put(source.id, node)
        sources.add(source)
    }

    fun <T, E> connect(emitter: EmitterWrapper<T>, operator: OperatorWrapper<T, E>) {
        val parent = nodes[emitter.id] ?: throw IllegalArgumentException("No node found with id ${emitter.id}")
        val child = StreamElementNode(operator)
        connect(parent, child)
    }

    fun <T> connect(emitter: EmitterWrapper<T>, sink: SinkWrapper<T>) {
        val parent = nodes[emitter.id] ?: throw IllegalArgumentException("No node found with id ${emitter.id}")
        val child = StreamElementNode(sink)
        connect(parent, child)
    }

    private fun connect(parent: StreamElementNode, child: StreamElementNode) {
        parent.children.add(child)
        nodes.put(child.element.id, child)
    }

    override fun print() {
        println("Stream : $id")
        tree.forEach { n ->
            print(" - ")
            n.print()
            println()
        }
    }

    override fun start() {
        sources.forEach { s -> s.start() }
    }

    override fun stop() {
        sources.forEach { s -> s.stop() }
    }

}

private data class StreamElementNode(
    val element: StreamElement,
    val children: MutableList<StreamElementNode> = mutableListOf()
) {
    fun print() {
        print(element.key())
        if (children.isNotEmpty()) {
            print(" -> ")
            children.forEach { it.print() }
        }
    }

    fun StreamElement.key(): String {
        return "$id|$name"
    }
}