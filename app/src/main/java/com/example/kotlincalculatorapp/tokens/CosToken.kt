package com.example.kotlincalculatorapp.tokens

import com.example.kotlincalculatorapp.constants.TokenConstants
import com.example.kotlincalculatorapp.enums.TokenType

class CosToken(index: Int): Token(index) {
    override fun getText(): String {
        return TokenConstants.COS
    }

    override fun getTokenType(): TokenType {
        return TokenType.COS
    }
}