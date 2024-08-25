package com.example.kotlincalculatorapp.tokens

import com.example.kotlincalculatorapp.constants.TokenConstants.DIV
import com.example.kotlincalculatorapp.enums.TokenType

class DivToken(index: Int) : Token(index) {
    override fun getText(): String {
        return DIV
    }

    override fun getTokenType(): TokenType {
        return TokenType.DIV
    }
}