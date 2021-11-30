package com.example.example.simulacaocredito.service.chain

import com.example.example.simulacaocredito.model.dto.ProcessoDTO

interface IProcessoSimulacaoService {
    fun execute(processo: ProcessoDTO)
}