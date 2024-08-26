package com.example.kotlincalculatorapp.tokens

import com.example.kotlincalculatorapp.constants.TokenConstants
import com.example.kotlincalculatorapp.enums.TokenType

class TanToken(index: Int): Token(index) {
    override fun getText(): String {
        return TokenConstants.TAN
    }

    override fun getTokenType(): TokenType {
        return TokenType.TAN
    }
}