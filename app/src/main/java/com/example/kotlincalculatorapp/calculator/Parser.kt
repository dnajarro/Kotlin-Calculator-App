package com.example.kotlincalculatorapp.calculator

import com.example.kotlincalculatorapp.astNodes.BinopNode
import com.example.kotlincalculatorapp.astNodes.Node
import com.example.kotlincalculatorapp.astNodes.NonexistNode
import com.example.kotlincalculatorapp.astNodes.NumNode
import com.example.kotlincalculatorapp.astNodes.ParenthesisNode
import com.example.kotlincalculatorapp.enums.TokenType
import com.example.kotlincalculatorapp.tokens.Token

class Parser {

    // TODO go through identify how the nodes fit into AST syntax and return an AST node
    // TODO add parenthesis nodes to all nodes so that binop nodes for example don't get PEMDAS wrong
    fun parse(tokens: List<Token>, nodes: MutableList<Node>): Node {
        if (tokens.isEmpty()) {
            return NonexistNode(-1)
        }

        var newNodesList: MutableList<Node> = nodes.toMutableList()
        newNodesList = convertBinopNodes(tokens, newNodesList)
        newNodesList = convertNumNodes(tokens, newNodesList)
        return convertParenNode(newNodesList)

    }

    private fun convertNumNodes(tokens: List<Token>, nodes: MutableList<Node>): MutableList<Node> {
        for (i in 0 until tokens.size) {
            val token: Token = tokens.get(i)
            if (!token.visited) {
                if (isNumToken(token)) {
                    tokens.get(i).visited = true
                    nodes.add(NumNode(token.index, token.getText()))
                }
            }
        }

        return nodes
    }

    private fun convertBinopNodes(tokens: List<Token>, nodes: MutableList<Node>): MutableList<Node> {
        for (i in 0 until tokens.size) {
            val token: Token = tokens.get(i)
            if (!token.visited) {
                if (isArithToken(token)) {
                    token.visited = true
                    val leftNode: Node = parse(tokens.subList(0, i), nodes)
                    val rightNode: Node = parse(tokens.subList(i + 1, tokens.size), nodes)
                    nodes.add(0, BinopNode(i, leftNode, rightNode, tokens.get(i)))
                }
            }
        }

        return nodes
    }

    private fun convertParenNode(nodes: MutableList<Node>): Node {
        if (nodes.size == 0) return NonexistNode(-1)
        if (nodes.size == 1) return nodes.get(0)
        val index: Int = getFirstNodeIndex(nodes)
        return ParenthesisNode(index, nodes)
    }

    private fun getFirstNodeIndex(nodes: MutableList<Node>): Int {
        var smallestIndex: Int = 1000000
        for (node in nodes) {
            if (node.index < smallestIndex) smallestIndex = node.index
        }

        return smallestIndex
    }

    private fun isNumToken(token: Token): Boolean {
        return token.getTokenType().equals(TokenType.NUM)
    }

    private fun isArithToken(token: Token): Boolean {
        if (!token.getTokenType().equals(TokenType.PLUS) && !token.getTokenType().equals(TokenType.MINUS))
            return false
        return true
    }

}