package com.example.kotlincalculatorapp.astNodes

import com.example.kotlincalculatorapp.enums.TokenType
import com.example.kotlincalculatorapp.tokens.Token

interface IFindMatchingOperators {
    fun findMatchingOperators(nodes: List<Token>, nodeTypes: Set<TokenType>): Token
}