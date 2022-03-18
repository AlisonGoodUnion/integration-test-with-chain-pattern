package com.example.example.simulacaocredito.service.chain.services

import com.example.example.simulacaocredito.model.dto.ResultadoSimulacaoResponseDTO
import com.example.example.simulacaocredito.model.dto.SimulacaoCreditoRequestDTO
import com.example.example.simulacaocredito.model.dto.TaxaDTO

interface ICreditoService {
    fun realizarSimulacao(simulacaoCreditoRequestDTO: SimulacaoCreditoRequestDTO): ResultadoSimulacaoResponseDTO
    fun criarTaxa(taxaDTO: TaxaDTO): TaxaDTO
    fun buscarTaxas(id: Long?): List<TaxaDTO>
}