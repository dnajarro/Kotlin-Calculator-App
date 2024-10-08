package com.example.kotlincalculatorapp.tokens

import com.example.kotlincalculatorapp.constants.TokenConstants
import com.example.kotlincalculatorapp.enums.TokenType

class NonexistToken(index: Int): Token(index) {
    override fun getText(): String {
        return TokenConstants.NONEXIST
    }

    override fun getTokenType(): TokenType {
        return TokenType.NONEXIST
    }
}