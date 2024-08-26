package com.example.kotlincalculatorapp.tokens

import com.example.kotlincalculatorapp.constants.TokenConstants
import com.example.kotlincalculatorapp.enums.TokenType

class LeftParenToken(index: Int): Token(index) {
    override fun getText(): String {
        return TokenConstants.LEFTPAREN
    }

    override fun getTokenType(): TokenType {
        return TokenType.LEFTPAREN
    }
}