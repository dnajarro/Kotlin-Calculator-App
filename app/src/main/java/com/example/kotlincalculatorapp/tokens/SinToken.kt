package com.example.kotlincalculatorapp.tokens

import com.example.kotlincalculatorapp.constants.TokenConstants
import com.example.kotlincalculatorapp.enums.TokenType

class SinToken(index: Int): Token(index) {
    override fun getText(): String {
        return TokenConstants.SIN
    }

    override fun getTokenType(): TokenType {
        return TokenType.SIN
    }
}