package com.example.kotlincalculatorapp.calculator

import com.example.kotlincalculatorapp.constants.TokenConstants
import com.example.kotlincalculatorapp.enums.TokenType
import com.example.kotlincalculatorapp.tokens.MinusToken
import com.example.kotlincalculatorapp.tokens.Token
import com.example.kotlincalculatorapp.tokens.NonexistToken
import com.example.kotlincalculatorapp.tokens.NumToken
import com.example.kotlincalculatorapp.tokens.PlusToken
import java.util.regex.Matcher
import java.util.regex.Pattern


class Tokenizer {
    fun tokenize(input: String): List<Token> {
        var curIndex: Int = 0
        val tokens: MutableList<Token> = ArrayList()
        // TODO: look through string and isolate all tokens and add them to tokens list if valid token
        while (curIndex < input.length) {
            val t: Token = this.findNextNode(curIndex, input.substring(curIndex))
            if (t.getTokenType() != TokenType.NONEXIST)
                tokens.add(t)
            // take current index, start at the location of the token (accounting for whitespace),
            // and move curIndex to end of token
            curIndex += input.substring(curIndex).indexOf(t.getText()) + t.getText().length
        }

        return tokens
    }

    fun findNextNode(curIndex: Int, substr: String): Token {
        if (!substr.isEmpty()) {
            // TODO: add all subfunctions for finding each type of token and compare them to decide on actual token
            var tokenCandidates: MutableList<Token> = ArrayList()
            tokenCandidates.add(findNumNode(curIndex, substr))
            tokenCandidates.add(findPlusNode(curIndex, substr))
            tokenCandidates.add(findMinusNode(curIndex, substr))
            tokenCandidates.sort()
            for (t in tokenCandidates) {
                if (!t.getTokenType().equals(TokenType.NONEXIST))
                    return t
            }
            return NonexistToken(-1, substr)
        }
        val token: Token = NonexistToken(-1, substr)
        return token
    }

    fun findNumNode(curIndex: Int, substr: String): Token {
        val numRegex: String = /** "-?\\d+(\\.\\d+)?" **/ "\\d+(\\.\\d+)?"
        val pattern: Pattern = Pattern.compile(numRegex)
        val matcher: Matcher = pattern.matcher(substr)
        if (matcher.find()) {
            return NumToken(curIndex + substr.indexOf(matcher.group()), matcher.group())
        }
        return NonexistToken(-1, "")
    }

    fun findPlusNode(curIndex: Int, substr: String): Token {
        var token = ""
        val index = substr.indexOf(TokenConstants.PLUS)
        val nodeType: TokenType = TokenType.NONEXIST

        if (index != -1) {
            return PlusToken(curIndex + index)
        }
        return NonexistToken(index, token)
    }

    fun findMinusNode(curIndex: Int, substr: String): Token {
        var token = ""
        val index = substr.indexOf(TokenConstants.MINUS)
        var tokenType: TokenType = TokenType.NONEXIST

        if (index != -1) {
            return MinusToken(curIndex + index)
        }
        return NonexistToken(index, token)
    }
}