package com.example.kotlincalculatorapp.tokens

import com.example.kotlincalculatorapp.constants.TokenConstants.MULT
import com.example.kotlincalculatorapp.enums.TokenType

class MultToken(index: Int) : Token(index) {
    override fun getText(): String {
        return MULT
    }

    override fun getTokenType(): TokenType {
        return TokenType.MULT
    }
}