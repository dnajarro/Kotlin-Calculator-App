package com.example.kotlincalculatorapp.calculator

import com.example.kotlincalculatorapp.enums.TokenType
import com.example.kotlincalculatorapp.token.Token

class Tokenizer {
    fun tokenize(input: String): List<String> {
        var curIndex: Int = 0
        val tokens: MutableList<Token> = ArrayList()
        // TODO: look through string and isolate all tokens and add them to tokens list if valid token
        while (curIndex < input.length) {
            val t: Token = this.findNextToken(input.substring(curIndex))
            if (t.type != TokenType.NONEXIST)
                tokens.add(t)
            // take current index, start at the location of the token (accounting for whitespace),
            // and move curIndex to end of token
            curIndex += input.substring(curIndex).indexOf(t.token) + t.token.length
        }
        // convert list of tokens to strings (Interpreter doesn't need to know about Token class)
        val tokensAsStrings: MutableList<String> = ArrayList()
        for (t in tokens) {
            tokensAsStrings.add(t.token)
        }
        return tokensAsStrings
    }

    fun findNextToken(substr: String): Token {
        // TODO: add all subfunctions for finding each type of token and compare them to decide on actual token
        val token: Token = Token(substr, -1, TokenType.NONEXIST)
        return token
    }
}