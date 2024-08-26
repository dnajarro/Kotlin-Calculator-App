package com.example.kotlincalculatorapp.tokens

import com.example.kotlincalculatorapp.constants.TokenConstants
import com.example.kotlincalculatorapp.enums.TokenType

class SqrtToken(index: Int): Token(index) {
    override fun getText(): String {
        return TokenConstants.SQRT
    }

    override fun getTokenType(): TokenType {
        return TokenType.SQRT
    }
}