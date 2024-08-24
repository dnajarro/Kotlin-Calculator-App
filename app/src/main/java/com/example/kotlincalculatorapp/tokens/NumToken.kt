package com.example.kotlincalculatorapp.tokens

import com.example.kotlincalculatorapp.enums.TokenType

class NumToken(index: Int, val numVal: String): Token(index) {
    override fun getText(): String {
        return numVal
    }

    override fun getTokenType(): TokenType {
        return TokenType.NUM
    }
}