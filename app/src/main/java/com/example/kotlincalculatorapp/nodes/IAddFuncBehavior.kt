package com.example.kotlincalculatorapp.nodes

interface IAddFuncBehavior {
    fun add(nodes: List<Node>, n: Node): List<Node>
}