package com.example.kotlincalculatorapp.calculator

import com.example.kotlincalculatorapp.exceptions.BadCalculationException
import com.example.kotlincalculatorapp.nodes.Node

class Interpreter {

    // 1. Tokenizer - tokenize the string
    // 2. Parser - place the tokens in an AST to impose syntax
    // 3. Semantic Analyzer - ensure the semantics of the AST are correct (i.e., make sure expression is valid, parentheses for example)
    // 4. Interpreter/Evaluation - Run the final calculations
    // 5. Error Handling - handle any errors that happen in parsing or evaluation
    // 6. Output

    fun interp(input: String): String {
        val tokenizer = Tokenizer()
        val parser = Parser()
        val semAnalyzer = SemAnalyzer()
        var result: String = ""
        try {
            val tokens: List<String> = tokenizer.tokenize(input)
            val ast: Node = parser.parse(tokens)
            val analyzedAST: Node = semAnalyzer.analyze(ast)
            result = formatNumbers(calc(analyzedAST))
        } catch (e: Exception) {
            result = e.message.toString()
        }

        return result
    }

    private fun calc(ast: Node): Double {
        var result: Double = java.lang.Double.MIN_NORMAL
        if (isArithNode(ast) || isNumNode(ast)) {
            result = ast.eval()
            if (result == java.lang.Double.MIN_NORMAL) {
                throw BadCalculationException("Error in Calculator.calc: Invalid calculation")
            } else {
                if (isParenNode(ast))
                    result = evalInOrder(ast)
                else if (isUnopNode(ast)) {
                    evalInOrder(ast)
                    result = ast.eval()
                }
            }
        } else {
            throw NullPointerException("Error in Calculator.calc: Calculator can't calculate without any numbers or symbols to calculate!")
        }
        return result
    }

    private fun evalInOrder(n: Node): Double {
        // TODO
        return 0.0
    }

    private fun isNumNode(n: Node): Boolean {
        // TODO
        return true
    }

    private fun isArithNode(n: Node): Boolean {
        // TODO
        return true
    }

    private fun isParenNode(n: Node): Boolean {
        // TODO
        return true
    }

    private fun isUnopNode(n: Node): Boolean {
        // TODO
        return true
    }

    private fun formatNumbers(d: Double): String {
        // TODO
        return "0.0"
    }
}