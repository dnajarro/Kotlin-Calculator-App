package com.example.kotlincalculatorapp.tokens

import com.example.kotlincalculatorapp.constants.TokenConstants.PLUS
import com.example.kotlincalculatorapp.enums.TokenType

class PlusToken(index: Int): Token(index) {
    override fun getText(): String {
        return PLUS
    }

    override fun getTokenType(): TokenType {
        return TokenType.PLUS
    }
}