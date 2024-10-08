package com.example.kotlincalculatorapp.astNodes

import com.example.kotlincalculatorapp.enums.NodeType

abstract class Node() {

    abstract fun getText(): String

    open fun eval(): Double {
        return java.lang.Double.MIN_NORMAL
    }

    open fun getNodeType(): NodeType {
        return NodeType.NODE
    }
}