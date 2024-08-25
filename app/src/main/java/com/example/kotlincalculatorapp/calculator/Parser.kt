package com.example.kotlincalculatorapp.calculator

import com.example.kotlincalculatorapp.astNodes.BinopNode
import com.example.kotlincalculatorapp.astNodes.Node
import com.example.kotlincalculatorapp.astNodes.NonexistNode
import com.example.kotlincalculatorapp.astNodes.NumNode
import com.example.kotlincalculatorapp.astNodes.ParenthesisNode
import com.example.kotlincalculatorapp.constants.TokenConstants
import com.example.kotlincalculatorapp.enums.TokenType
import com.example.kotlincalculatorapp.tokens.Token
import java.util.Stack

class Parser {
    // TODO go through identify how the nodes fit into AST syntax and return an AST node
    // TODO add parenthesis nodes to all nodes so that binop nodes for example don't get PEMDAS wrong
    fun parse(tokens: List<Token>, nodes: MutableList<Node>): Node {
        if (tokens.isEmpty()) {
            return NonexistNode()
        }

        return buildExpressionTree(tokens)
    }

    fun buildExpressionTree(tokens: List<Token>): Node {
        val nodes: Stack<Node> = Stack<Node>()
        val operators: Stack<Token> = Stack<Token>()

        for (token in tokens) {
            if (isNumToken(token)) {
                nodes.push(NumNode(token.getText()))
            } else if (isArithToken(token)) {
                if (operators.isNotEmpty() && nodes.isNotEmpty() && nodes.peek() is BinopNode) {
                    val invalidBinopNode: BinopNode = createInvalidBinopNode(token)
                    nodes.push(ParenthesisNode(listOf(invalidBinopNode)))
                }

                while (operators.isNotEmpty() &&
                    precedence(operators.peek().getText()) >= precedence(token.getText())) {
                    nodes.push(createBinopNode(nodes, operators))
                }
                operators.push(token)
            } else {
                // invalid token, doesn't appear in the grammar
            }
        }

        while (operators.isNotEmpty()) {
            nodes.push(createBinopNode(nodes, operators))
        }

        return nodes.pop()
    }

    private fun createBinopNode(nodes: Stack<Node>, operators: Stack<Token>): BinopNode {
        val operator = operators.pop()
        if (nodes.size > 1) {
            val right = nodes.pop()
            val left = nodes.pop()
            return BinopNode(left, right, operator)
        } else if (nodes.isNotEmpty()) {
            val right: Node = nodes.pop()
            val left: Node = NonexistNode()
            return BinopNode(left, right, operator)
        } else {
            val right: Node = NonexistNode()
            val left: Node = NonexistNode()
            return BinopNode(left, right, operator)
        }
    }

    private fun createInvalidBinopNode(token: Token): BinopNode {
        return BinopNode(NonexistNode(), NonexistNode(), token)
    }

    fun precedence(value: String): Int {
        return when (value) {
            TokenConstants.PLUS, TokenConstants.MINUS -> 1
            TokenConstants.MULT, TokenConstants.DIV -> 2
            else -> -1
        }
    }

    private fun isNumToken(token: Token): Boolean {
        return token.getTokenType().equals(TokenType.NUM)
    }

    private fun isArithToken(token: Token): Boolean {
        if (!token.getTokenType().equals(TokenType.PLUS)
            && !token.getTokenType().equals(TokenType.MINUS)
            && !token.getTokenType().equals(TokenType.MULT)
            && !token.getTokenType().equals(TokenType.DIV))
            return false
        return true
    }

}