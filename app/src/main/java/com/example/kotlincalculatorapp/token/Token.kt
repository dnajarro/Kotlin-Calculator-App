package com.example.kotlincalculatorapp.token

import com.example.kotlincalculatorapp.enums.TokenType

class Token(val token: String, val index: Int, val type: TokenType) {
    companion object {
        const val PLUS: String = "+"
        const val MINUS: String = "-"
        const val DIV: String = "/"
        const val MULT: String = "*"
        const val EXP: String = "^"
        const val SQRTOPEN: String = "sqrt("
        const val OPENREGPAREN: String = "("
        const val OPENCURLYPAREN: String = "{"
        const val OPENSQPAREN: String = "["
        const val CLOSEREGPAREN: String = ")"
        const val CLOSECURLYPAREN: String = "}"
        const val CLOSESQPAREN: String = "]"
        const val LOGOPEN: String = "log("
        const val NATLOGOPEN: String = "ln("
        const val SINOPEN: String = "sin("
        const val COSOPEN: String = "cos("
        const val TANOPEN: String = "tan("
    }


}