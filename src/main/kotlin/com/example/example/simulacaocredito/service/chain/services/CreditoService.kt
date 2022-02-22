package com.example.example.simulacaocredito.service.chain.services

import com.example.example.simulacaocredito.model.dto.ProcessoDTO
import com.example.example.simulacaocredito.model.dto.ResultadoSimulacaoResponseDTO
import com.example.example.simulacaocredito.model.dto.SimulacaoCreditoRequestDTO
import com.example.example.simulacaocredito.service.chain.IProcessoSimulacaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CreditoService @Autowired constructor(
    private val processoSimulacao: List<IProcessoSimulacaoService>,
    private val resultadoService: ResultadoService
) : ICreditoService {

    override fun realizarSimulacao(simulacaoCreditoRequestDTO: SimulacaoCreditoRequestDTO): ResultadoSimulacaoResponseDTO {
        val processoDTO = ProcessoDTO(simulacaoCreditoRequestDTO.id)

        processoSimulacao.forEach { it.execute(processoDTO) }
        return resultadoService.obter(processoDTO)
    }
}