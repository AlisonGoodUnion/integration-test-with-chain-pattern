package com.example.example.simulacaocredito.facade

import org.junit.jupiter.api.Test

internal class TradutorManagerTest {
    @Test
    fun deveRealizarTraducaoTraduzir() {
        TradutorManager().traduzir(
                texto = "Ola",
                de = Linguagem.English,
                para = Linguagem.Italian)

        TradutorManager().traduzir(
                texto = "Ola",
                de = Linguagem.English,
                para = Linguagem.French)
    }
}
