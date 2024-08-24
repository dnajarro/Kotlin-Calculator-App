package com.example.kotlincalculatorapp.astNodes

import com.example.kotlincalculatorapp.constants.TokenConstants
import com.example.kotlincalculatorapp.enums.NodeType
import com.example.kotlincalculatorapp.enums.TokenType
import com.example.kotlincalculatorapp.tokens.Token

class BinopNode(index: Int, val leftChild: Node, val rightChild: Node, val operator: Token): Node(index){
    override fun getText(): String {
        return leftChild.getText() + operator.getText() + rightChild.getText()
    }

    override fun getNodeType(): NodeType {
        if (operator.getTokenType().equals(TokenType.PLUS) || operator.getText().equals(TokenType.MINUS))
            return NodeType.ARITHMETIC
        return NodeType.NODE
    }

    override fun eval(): Double {
        if (operator.getTokenType().equals(TokenType.PLUS))
            return leftChild.eval() + rightChild.eval()
        if (operator.getTokenType().equals(TokenType.MINUS))
            return leftChild.eval() - rightChild.eval()
        return super.eval()
    }
}