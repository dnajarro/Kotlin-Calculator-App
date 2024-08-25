package com.example.kotlincalculatorapp.astNodes

import com.example.kotlincalculatorapp.enums.NodeType

class NumNode(val value: String): Node() {
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