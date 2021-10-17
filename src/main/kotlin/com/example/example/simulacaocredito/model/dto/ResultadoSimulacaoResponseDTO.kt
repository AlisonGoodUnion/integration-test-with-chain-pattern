package com.example.example.simulacaocredito.model.dto

import java.math.BigDecimal

class ResultadoSimulacaoResponseDTO(
    var idProposta: Long?,

    var valorSugerido: BigDecimal? = null,
    var valorFinanciado: BigDecimal? = null,

    var taxaJuros: BigDecimal? = null,
    var periodoTaxaJuros: String? = null,

    var tipoResultado: String? = null,
    var mensagem: String? = null,
) {


    //Step1
    fun informarValores(valorSugerido: BigDecimal, valorFinanciado: BigDecimal) {
        this.valorSugerido = valorSugerido
        this.valorFinanciado = valorFinanciado
    }

    //Step2
    fun informarDadosTaxa(taxaJuros: BigDecimal, periodoTaxaJuros: String) {
        this.taxaJuros = taxaJuros
        this.periodoTaxaJuros = periodoTaxaJuros
    }

    //Step3
    fun informarResultado(tipoResultado: String, mensagem: String) {
        this.tipoResultado = tipoResultado
        this.mensagem = mensagem
    }
}