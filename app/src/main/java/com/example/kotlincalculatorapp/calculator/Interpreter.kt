package com.example.kotlincalculatorapp.calculator

import com.example.kotlincalculatorapp.astNodes.Node
import com.example.kotlincalculatorapp.constants.InterpreterConstants
import com.example.kotlincalculatorapp.tokens.Token
import java.util.Locale
import kotlin.math.pow

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
            val tokens: List<Token> = tokenizer.tokenize(input)
            val ast: Node = parser.parse(tokens, mutableListOf())
            val ASTAnalysisResults: String = semAnalyzer.analyze(ast)
            if (isValidSyntax(ASTAnalysisResults)) {
                return formatNumbers(calc(ast))
            }

            return ASTAnalysisResults
        }

        private fun calc(ast: Node): Double {
            return ast.eval()
        }

        private fun isValidSyntax(result: String): Boolean {
            return result.equals(InterpreterConstants.VALID)
        }

        private fun formatNumbers(d: Double): String {
            if (d.toString().contains(".")) {
                return "%s".format(d)
            }
            return String.format(Locale.getDefault(), "%d", d.toInt())
        }
    }
}