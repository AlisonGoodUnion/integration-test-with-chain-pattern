package com.example.example.simulacaocredito.facade

enum class Linguagem {
    English,
    Italian,
    French;
}

interface TradutorFacade {
    fun traduzir(texto: String, linguagem: Linguagem)
}

class TradutorItalian: TradutorFacade {
    override fun traduzir(texto: String, linguagem: Linguagem) {
        println("Traduzir: $texto para $linguagem")
    }
}

class TradutorFrench: TradutorFacade {
    override fun traduzir(texto: String, linguagem: Linguagem) {
        println("Traduzir: $texto para $linguagem")
    }
}

class TradutorEnglish: TradutorFacade {
    override fun traduzir(texto: String, linguagem: Linguagem) {
        println("Traduzir: $texto para $linguagem")
    }
}