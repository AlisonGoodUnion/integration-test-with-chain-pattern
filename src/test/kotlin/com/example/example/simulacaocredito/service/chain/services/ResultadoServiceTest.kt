package com.example.example.simulacaocredito.service.chain.services

import com.example.example.simulacaocredito.model.dto.ProcessoDTO
import com.example.example.simulacaocredito.service.enums.PeriodicidadeEnum
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.junit.jupiter.MockitoExtension
import java.math.BigDecimal

@ExtendWith(MockitoExtension::class)
internal class ResultadoServiceTest {

    @InjectMocks
    lateinit var resultadoService: ResultadoService

    lateinit var processoMock: ProcessoDTO

    @BeforeEach
    fun setUp() {
        processoMock = ProcessoDTO(1L)
        processoMock.informarValores(BigDecimal.TEN)
        processoMock.informarDadosTaxa(BigDecimal.TEN, PeriodicidadeEnum.A)
    }

    // deveRetornarMSGTaxaQuandoValorMaiorCinco()
    // deveRetornarMSGTaxaQuandoValorMaiorCinco()

    @Test
    fun deveObterResultadoReprovadoQuandoLimiteMenor() {
        val obtained = resultadoService.obter(processoMock)
        Assertions.assertEquals("REPROVADO", obtained.tipoResultado)
    }

    @Test
    fun deveObterResultadoAprovadoQuandoLimiteMaior() {
        processoMock.informarValores(BigDecimal(1001L))
        val obtained = resultadoService.obter(processoMock)
        Assertions.assertEquals("APROVADO", obtained.tipoResultado)
    }

    @Test
    fun deveObterResultadoAprovadoQuandoLimiteIgual() {
        processoMock.informarValores(BigDecimal(1000L))
        val obtained = resultadoService.obter(processoMock)
        Assertions.assertEquals("REPROVADO", obtained.tipoResultado)
    }

    @Test
    fun deveObterResultadoAprovadoQuandoLimiteMaior12() {
        processoMock.informarValores(BigDecimal(1001L))
        val obtained = resultadoService.obter(processoMock)
        Assertions.assertEquals("APROVADO", obtained.tipoResultado)
    }

    @Test
    fun quandoTaxaZeroDeveOcorrerException() {
        processoMock.informarValores(BigDecimal(1001L))
        processoMock.informarDadosTaxa(BigDecimal.ZERO, PeriodicidadeEnum.B)

//        try {
//            val obtained = resultadoService.obter(processoMock)
//        } catch (excepton: Exception) {
//            Assertions.assertEquals("Taxa de Juros invalida", excepton.message)
//        }

        val messageError = Assertions.assertThrows(IllegalAccessException::class.java) {
            val obtained = resultadoService.obter(processoMock)
        }.message

        Assertions.assertEquals("Taxa de Juros invalida", messageError)
    }

    @Test
    fun deveObterResultadoReprovado() {

        processoMock = ProcessoDTO(1L)
        processoMock.informarValores(BigDecimal.TEN)
        processoMock.informarDadosTaxa(BigDecimal.TEN, PeriodicidadeEnum.A)
    }


}