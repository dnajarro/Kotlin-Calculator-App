package com.example.kotlincalculatorapp.tokens

import com.example.kotlincalculatorapp.constants.TokenConstants.MINUS
import com.example.kotlincalculatorapp.enums.TokenType

class MinusToken(index: Int) : Token(index) {
    override fun getText(): String {
        return MINUS
    }

    override fun getTokenType(): TokenType {
        return TokenType.MINUS
    }
}
