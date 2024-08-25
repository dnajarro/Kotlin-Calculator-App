package com.example.kotlincalculatorapp.astNodes

import com.example.kotlincalculatorapp.enums.NodeType

class ParenthesisNode(val expression: List<Node>): Node() {
    override fun getText(): String {
        return buildString {
            for (i in 0 until expression.size) {
                append(expression.get(i).getText())
                if (i < expression.size - 1) append(" ")
            }
        }
    }

    override fun getNodeType(): NodeType {
        return NodeType.PARENTHESIS
    }

    override fun eval(): Double {
        if (expression.size != 1) return super.eval()
        val node: Node = expression.get(0)
        if (node.getNodeType().equals(NodeType.NUM)) return node.eval()
        return super.eval()
    }
}