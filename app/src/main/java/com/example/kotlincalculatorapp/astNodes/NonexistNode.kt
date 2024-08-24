package com.example.kotlincalculatorapp.astNodes

import com.example.kotlincalculatorapp.constants.NodeConstants
import com.example.kotlincalculatorapp.enums.NodeType

class NonexistNode(index: Int): Node(index) {
    override fun getText(): String {
        return NodeConstants.NONEXIST
    }

    override fun getNodeType(): NodeType {
        return NodeType.NONEXIST
    }
}