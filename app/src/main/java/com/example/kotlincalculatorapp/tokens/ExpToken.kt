package com.example.kotlincalculatorapp.tokens

import com.example.kotlincalculatorapp.constants.TokenConstants
import com.example.kotlincalculatorapp.enums.TokenType

class ExpToken(index: Int): Token(index) {
    override fun getText(): String {
        return TokenConstants.EXP
    }

    override fun getTokenType(): TokenType {
        return TokenType.EXP
    }
}