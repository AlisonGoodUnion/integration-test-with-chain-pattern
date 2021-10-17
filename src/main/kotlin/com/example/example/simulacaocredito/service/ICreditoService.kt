package com.example.example.simulacaocredito.service

import com.example.example.simulacaocredito.model.dto.ResultadoSimulacaoResponseDTO

interface ICreditoService {
    fun realizarSimulacao(idProposta: Long): ResultadoSimulacaoResponseDTO
}