package com.example.example.simulacaocredito.builder

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CarroTest {
    @Test
    fun deveConstruirCarroComValoresNulos() {
        val buildNull = Carro.Builder().build()
        Assertions.assertNull(buildNull.cor)
    }

    @Test
    fun deveConstruirCarroApenasComCor() {
        val carroAzul = Carro.Builder().cor("Azul").build()
        Assertions.assertEquals(carroAzul.cor, "Azul")
        Assertions.assertNull(carroAzul.modelo)
        Assertions.assertNull(carroAzul.tipo)
    }

    @Test
    fun deveCriarInstanciaDeCarroBuilder() {
        val carroAzul = Carro.Builder()
        Assertions.assertTrue(carroAzul is Carro.Builder)
        Assertions.assertNull(carroAzul.modelo)
        Assertions.assertNull(carroAzul.tipo)
    }

    @Test
    fun deveCriarInstanciaDeCarro() {
        val carroAzul = Carro.Builder().build()
        Assertions.assertTrue(carroAzul is Carro)
        Assertions.assertNull(carroAzul.modelo)
        Assertions.assertNull(carroAzul.tipo)
    }
}