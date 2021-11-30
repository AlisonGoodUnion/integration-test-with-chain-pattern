package com.example.example.simulacaocredito.model.dto

import com.example.example.simulacaocredito.service.enums.PeriodicidadeEnum
import java.math.BigDecimal

class ProcessoDTO(
    var idProposta: Long,
) {
    var valorFinanciado: BigDecimal? = null
    var taxaJuros: BigDecimal? = null
    var periodoTaxaJuros: PeriodicidadeEnum? = null

    //Step1
    fun informarValores(valorFinanciado: BigDecimal) {
        println("populando valor $valorFinanciado")
        this.valorFinanciado = valorFinanciado
    }

    //Step2
    fun informarDadosTaxa(taxaJuros: BigDecimal, periodoTaxaJuros: PeriodicidadeEnum) {
        println("populando valor $taxaJuros")
        this.taxaJuros = taxaJuros
        println("populando valor $periodoTaxaJuros")
        this.periodoTaxaJuros = periodoTaxaJuros

    }

}