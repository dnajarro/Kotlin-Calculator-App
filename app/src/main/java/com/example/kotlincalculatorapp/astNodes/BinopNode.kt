package com.example.kotlincalculatorapp.astNodes

import com.example.kotlincalculatorapp.constants.TokenConstants
import com.example.kotlincalculatorapp.enums.NodeType
import com.example.kotlincalculatorapp.enums.TokenType
import com.example.kotlincalculatorapp.tokens.Token

class BinopNode(val leftChild: Node, val rightChild: Node, val operator: Token): Node(){
    override fun getText(): String {
        return leftChild.getText() + operator.getText() + rightChild.getText()
    }

    override fun getNodeType(): NodeType {
        if (operator.getTokenType().equals(TokenType.PLUS)
            || operator.getTokenType().equals(TokenType.MINUS)
            || operator.getTokenType().equals(TokenType.MULT)
            || operator.getTokenType().equals(TokenType.DIV))
            return NodeType.ARITHMETIC
        return NodeType.NODE
    }

    fun getOperatorAsString(): String {
        return operator.getText()
    }

    override fun eval(): Double {
        if (operator.getTokenType().equals(TokenType.PLUS))
            return leftChild.eval() + rightChild.eval()
        if (operator.getTokenType().equals(TokenType.MINUS))
            return leftChild.eval() - rightChild.eval()
        if (operator.getTokenType().equals(TokenType.MULT))
            return leftChild.eval() * rightChild.eval()
        if (operator.getTokenType().equals(TokenType.DIV))
            return leftChild.eval() / rightChild.eval()
        return super.eval()
    }
}