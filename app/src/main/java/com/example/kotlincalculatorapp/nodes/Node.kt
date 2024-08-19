package com.example.kotlincalculatorapp.nodes

import com.example.kotlincalculatorapp.enums.NodeType

abstract class Node(
    val addFuncBehavior: IAddFuncBehavior,
    val findMatchingOperators: IFindMatchingOperators
) {

    abstract fun getText(): String

    open fun getNodeType(): NodeType {
        return NodeType.NODE
    }

    open fun findMatchingOperators(nodeType: Set<NodeType>): Node? {
        return null
    }

    open fun eval(): Double {
        return java.lang.Double.MIN_NORMAL
    }
}