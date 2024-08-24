package com.example.kotlincalculatorapp.calculator

import com.example.kotlincalculatorapp.astNodes.Node

class Calculator {
    fun calc(ast: Node): Double {
        return ast.eval()
    }
}