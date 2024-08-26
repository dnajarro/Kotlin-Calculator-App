package com.example.kotlincalculatorapp.tokens

import com.example.kotlincalculatorapp.constants.TokenConstants
import com.example.kotlincalculatorapp.enums.TokenType

class RightParenToken(index: Int): Token(index) {
    override fun getText(): String {
        return TokenConstants.RIGHTPAREN
    }

    override fun getTokenType(): TokenType {
        return TokenType.RIGHTPAREN
    }
}