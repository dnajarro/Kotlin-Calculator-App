package com.example.kotlincalculatorapp.tokens

import com.example.kotlincalculatorapp.enums.TokenType

abstract class Token(val index: Int): Comparable<Token>  {
    var visited: Boolean = false



    abstract fun getText(): String

    open fun getTokenType(): TokenType {
        return TokenType.NONEXIST
    }

    override fun compareTo(other: Token): Int {
        return this.index.compareTo(other.index)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true  // Check for reference equality
        if (other !is Token) return false  // Check if `other` is of the same type

        // Cast `other` to `Token` and compare the relevant properties
        return this.index == other.index && this.getText() == other.getText()
                && this.getTokenType() == other.getTokenType()
    }

    override fun hashCode(): Int {
        // Combine the hash codes of the relevant properties
        return index.hashCode() * 31 + getText().hashCode()
    }
}