package com.example.kotlincalculatorapp.tokens

import com.example.kotlincalculatorapp.enums.TokenType

class NonexistToken(index: Int, val str: String = ""): Token(index) {
    override fun getText(): String {
        return str
    }

    override fun getTokenType(): TokenType {
        return TokenType.NONEXIST
    }
}