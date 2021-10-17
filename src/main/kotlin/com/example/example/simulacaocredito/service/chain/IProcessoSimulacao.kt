package com.example.example.simulacaocredito.service.chain

import com.example.example.simulacaocredito.model.dto.ResultadoSimulacaoResponseDTO

interface IProcessoSimulacao {
    fun execute(resultado: ResultadoSimulacaoResponseDTO)
}