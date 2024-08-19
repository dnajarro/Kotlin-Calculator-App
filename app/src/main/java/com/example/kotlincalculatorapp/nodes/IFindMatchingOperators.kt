package com.example.kotlincalculatorapp.nodes

import com.example.kotlincalculatorapp.enums.NodeType

interface IFindMatchingOperators {
    fun findMatchingOperators(nodes: List<Node>, nodeTypes: Set<NodeType>): Node
}