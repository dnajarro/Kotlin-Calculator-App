package com.example.kotlincalculatorapp.astNodes

import com.example.kotlincalculatorapp.tokens.Token

interface IAddFuncBehavior {
    fun add(tokens: List<Token>, n: Token): List<Token>
}