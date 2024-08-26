package com.example.kotlincalculatorapp.tokens

import com.example.kotlincalculatorapp.constants.TokenConstants
import com.example.kotlincalculatorapp.enums.TokenType

class LogToken(index: Int): Token(index) {
    override fun getText(): String {
        return TokenConstants.LOG
    }

    override fun getTokenType(): TokenType {
        return TokenType.LOG
    }
}