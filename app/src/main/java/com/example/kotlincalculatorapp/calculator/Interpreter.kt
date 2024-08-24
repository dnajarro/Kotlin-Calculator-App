package com.example.kotlincalculatorapp.calculator

import com.example.kotlincalculatorapp.astNodes.Node
import com.example.kotlincalculatorapp.constants.InterpreterConstants
import com.example.kotlincalculatorapp.tokens.Token

class Interpreter {

    // 1. Tokenizer - tokenize the string
    // 2. Parser - place the tokens in an AST to impose syntax
    // 3. Semantic Analyzer - ensure the semantics of the AST are correct (i.e., make sure expression is valid, parentheses for example)
    // 4. Interpreter/Evaluation - Run the final calculations
    // 5. Error Handling - handle any errors that happen in parsing or evaluation
    // 6. Output

    companion object {
        fun interp(input: String): String {
            val tokenizer = Tokenizer()
            val parser = Parser()
            val semAnalyzer = SemAnalyzer()
            val calculator = Calculator()
            val tokens: List<Token> = tokenizer.tokenize(input)
            val ast: Node = parser.parse(tokens, mutableListOf())
            val ASTAnalysisResults: String = semAnalyzer.analyze(ast)
            if (ASTAnalysisResults.equals(InterpreterConstants.VALID)) {
                return formatNumbers(calculator.calc(ast))
            }

            return ASTAnalysisResults
        }

        private fun formatNumbers(d: Double): String {
            if (d.toString().contains(".")) {
                return "%s".format(d)
            }
            return String.format("%d", d.toInt())
        }

        private fun Double.hasDecimals(): Boolean {
            val threshold = 1e-9
            return Math.abs(this - this.toInt()) > threshold
        }
    }
}