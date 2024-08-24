package com.example.kotlincalculatorapp.astNodes

import com.example.kotlincalculatorapp.enums.NodeType

class NumNode(index: Int, val value: String): Node(index) {
    override fun getText(): String {
        return value
    }

    override fun getNodeType(): NodeType {
        return NodeType.NUM
    }

    override fun eval(): Double {
        return value.toDouble()
    }
}