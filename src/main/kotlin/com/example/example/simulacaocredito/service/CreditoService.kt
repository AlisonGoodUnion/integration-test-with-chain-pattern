package com.example.example.simulacaocredito.service

import com.example.example.simulacaocredito.model.dto.ResultadoSimulacaoResponseDTO
import com.example.example.simulacaocredito.service.chain.IProcessoSimulacao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class CreditoService @Autowired constructor(
private val passosSimulacao: List<IProcessoSimulacao>
) : ICreditoService {

    override fun realizarSimulacao(idProposta: Long): ResultadoSimulacaoResponseDTO {
        val resultado = ResultadoSimulacaoResponseDTO(idProposta = idProposta)
        // utilizando list de interface para executar steps do chain
        // steps descritas dentro da DTO ResultadoSimulacaoResponseDTO
        passosSimulacao.forEach { it.execute(resultado) }
        return resultado
    }
}