package com.example.kotlincalculatorapp.calculator

import com.example.kotlincalculatorapp.nodes.Node

class Parser {
    fun parse(tokens: List<String>): Node {
        lateinit var result: Node
        try {
            val nodes: List<Node> = makeBasicNodes(tokens)
            result = consolidateNodes(nodes);
        } catch (e: Exception) {
            // TODO
        } finally {
            // TODO
        }
        return result
    }

    private fun consolidateNodes(nodes: List<Node>): Node {
        // TODO
        return nodes.get(0)
    }

    private fun makeBasicNodes(tokens: List<String>): List<Node> {
        // TODO
        return ArrayList()
    }
}