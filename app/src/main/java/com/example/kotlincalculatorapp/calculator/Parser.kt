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
    // TODO add logic for parsing trig functions, parentheses, sqrt, and logathrimic functions
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

        // TODO: in a more robust interpreter, in the case of strings like "3 3 3" or "3 3 + 3 3",
        //  you need to account for nodes stack not being empty while operators stack being empty
        //  and potentially tracking left/rightedness of the num nodes (relative to operators)

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
            TokenConstants.EXP -> 3
            TokenConstants.LEFTPAREN, TokenConstants.RIGHTPAREN -> 4
            TokenConstants.SIN, TokenConstants.COS, TokenConstants.TAN -> 4
            TokenConstants.LOG, TokenConstants.NATLOG -> 4

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
            && !token.getTokenType().equals(TokenType.DIV)
            && !token.getTokenType().equals(TokenType.EXP))
            return false
        return true
    }

    private fun isTrigToken(token: Token): Boolean {
        if (!token.getTokenType().equals(TokenType.SIN)
            && !token.getTokenType().equals(TokenType.COS)
            && !token.getTokenType().equals(TokenType.TAN))
            return false
        return true
    }

    private fun isParenToken(token: Token): Boolean {
        if (!token.getTokenType().equals(TokenType.LEFTPAREN)
            && !token.getTokenType().equals(TokenType.RIGHTPAREN))
            return false
        return true
    }

    private fun isLogarithmicToken(token: Token): Boolean {
        if (!token.getTokenType().equals(TokenType.LOG)
            && !token.getTokenType().equals(TokenType.NATLOG))
            return false
        return true
    }

    private fun isSqrtToken(token: Token): Boolean {
        if (!token.getTokenType().equals(TokenType.SQRT))
            return false
        return true
    }
}