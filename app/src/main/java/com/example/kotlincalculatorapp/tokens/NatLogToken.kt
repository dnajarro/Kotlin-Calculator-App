package com.example.kotlincalculatorapp.tokens

import com.example.kotlincalculatorapp.constants.TokenConstants
import com.example.kotlincalculatorapp.enums.TokenType

class NatLogToken(index: Int): Token(index) {
    override fun getText(): String {
        return TokenConstants.NATLOG
    }

    override fun getTokenType(): TokenType {
        return TokenType.NATLOG
    }
}