package com.example.example.simulacaocredito.facade

class TradutorManager {
    private val italianTranslator = TradutorItalian()
    private val frenchTranslator = TradutorFrench()
    private val englishTranslator = TradutorEnglish()

    fun traduzir(texto: String, de: Linguagem, para: Linguagem) {
        when (para) {
            Linguagem.Italian -> italianTranslator.traduzir(texto, de)
            Linguagem.French -> frenchTranslator.traduzir(texto, de)
            Linguagem.English -> englishTranslator.traduzir(texto, de)
        }
    }
}