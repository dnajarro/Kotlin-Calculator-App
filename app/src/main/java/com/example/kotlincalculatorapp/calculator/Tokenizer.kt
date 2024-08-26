package com.example.kotlincalculatorapp.calculator

import com.example.kotlincalculatorapp.constants.TokenConstants
import com.example.kotlincalculatorapp.enums.TokenType
import com.example.kotlincalculatorapp.tokens.CosToken
import com.example.kotlincalculatorapp.tokens.DivToken
import com.example.kotlincalculatorapp.tokens.ExpToken
import com.example.kotlincalculatorapp.tokens.LeftParenToken
import com.example.kotlincalculatorapp.tokens.LogToken
import com.example.kotlincalculatorapp.tokens.MinusToken
import com.example.kotlincalculatorapp.tokens.MultToken
import com.example.kotlincalculatorapp.tokens.NatLogToken
import com.example.kotlincalculatorapp.tokens.Token
import com.example.kotlincalculatorapp.tokens.NonexistToken
import com.example.kotlincalculatorapp.tokens.NumToken
import com.example.kotlincalculatorapp.tokens.PlusToken
import com.example.kotlincalculatorapp.tokens.RightParenToken
import com.example.kotlincalculatorapp.tokens.SinToken
import com.example.kotlincalculatorapp.tokens.SqrtToken
import com.example.kotlincalculatorapp.tokens.TanToken
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
        if (substr.isNotEmpty()) {
            // TODO: add all subfunctions for finding each type of token and compare them to decide on actual token
            var tokenCandidates: MutableList<Token> = ArrayList()
            tokenCandidates.add(findNumToken(curIndex, substr))
            tokenCandidates.add(findPlusToken(curIndex, substr))
            tokenCandidates.add(findMinusToken(curIndex, substr))
            tokenCandidates.add(findMultToken(curIndex, substr))
            tokenCandidates.add(findDivToken(curIndex, substr))
            tokenCandidates.add(findExpToken(curIndex, substr))
            tokenCandidates.add(findLeftParenToken(curIndex, substr))
            tokenCandidates.add(findRightParenToken(curIndex, substr))
            tokenCandidates.add(findSqrtToken(curIndex, substr))
            tokenCandidates.add(findSinToken(curIndex, substr))
            tokenCandidates.add(findCosToken(curIndex, substr))
            tokenCandidates.add(findTanToken(curIndex, substr))
            tokenCandidates.add(findLogToken(curIndex, substr))
            tokenCandidates.add(findNatLogToken(curIndex, substr))
            tokenCandidates.sort()
            for (t in tokenCandidates) {
                if (!t.getTokenType().equals(TokenType.NONEXIST))
                    return t
            }
            return NonexistToken(-1)
        }
        val token: Token = NonexistToken(-1)
        return token
    }

    fun findNumToken(curIndex: Int, substr: String): Token {
        val numRegex: String = /** "-?\\d+(\\.\\d+)?" **/ "\\d+(\\.\\d+)?"
        val pattern: Pattern = Pattern.compile(numRegex)
        val matcher: Matcher = pattern.matcher(substr)

        if (matcher.find()) return NumToken(curIndex + substr.indexOf(matcher.group()), matcher.group())

        return NonexistToken(-1)
    }

    fun findPlusToken(curIndex: Int, substr: String): Token {
        val index = substr.indexOf(TokenConstants.PLUS)

        if (index != -1) return PlusToken(curIndex + index)

        return NonexistToken(index)
    }

    fun findMinusToken(curIndex: Int, substr: String): Token {
        val index = substr.indexOf(TokenConstants.MINUS)

        if (index != -1) return MinusToken(curIndex + index)

        return NonexistToken(index)
    }

    fun findMultToken(curIndex: Int, substr: String): Token {
        val index = substr.indexOf(TokenConstants.MULT)

        if (index != -1) return MultToken(curIndex + index)

        return NonexistToken(index)
    }

    fun findDivToken(curIndex: Int, substr: String): Token {
        val index = substr.indexOf(TokenConstants.DIV)

        if (index != -1) return DivToken(curIndex + index)

        return NonexistToken(index)
    }

    fun findExpToken(curIndex: Int, substr: String): Token {
        val index = substr.indexOf(TokenConstants.EXP)

        if (index != -1) return ExpToken(curIndex + index)

        return NonexistToken(index)
    }

    fun findLeftParenToken(curIndex: Int, substr: String): Token {
        val index = substr.indexOf(TokenConstants.LEFTPAREN)

        if (index != -1) return LeftParenToken(curIndex + index)

        return NonexistToken(index)
    }

    fun findRightParenToken(curIndex: Int, substr: String): Token {
        val index = substr.indexOf(TokenConstants.RIGHTPAREN)

        if (index != -1) return RightParenToken(curIndex + index)

        return NonexistToken(index)
    }

    fun findSqrtToken(curIndex: Int, substr: String): Token {
        val index = substr.indexOf(TokenConstants.SQRT)

        if (index != -1) return SqrtToken(curIndex + index)

        return NonexistToken(index)
    }

    fun findSinToken(curIndex: Int, substr: String): Token {
        val index = substr.indexOf(TokenConstants.SIN)

        if (index != -1) return SinToken(curIndex + index)

        return NonexistToken(index)
    }

    fun findCosToken(curIndex: Int, substr: String): Token {
        val index = substr.indexOf(TokenConstants.COS)

        if (index != -1) return CosToken(curIndex + index)

        return NonexistToken(index)
    }

    fun findTanToken(curIndex: Int, substr: String): Token {
        val index = substr.indexOf(TokenConstants.TAN)

        if (index != -1) return TanToken(curIndex + index)

        return NonexistToken(index)
    }

    fun findLogToken(curIndex: Int, substr: String): Token {
        val index = substr.indexOf(TokenConstants.LOG)

        if (index != -1) return LogToken(curIndex + index)

        return NonexistToken(index)
    }

    fun findNatLogToken(curIndex: Int, substr: String): Token {
        val index = substr.indexOf(TokenConstants.NATLOG)

        if (index != -1) return NatLogToken(curIndex + index)

        return NonexistToken(index)
    }
}