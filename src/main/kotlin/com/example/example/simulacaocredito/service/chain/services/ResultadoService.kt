package com.example.example.simulacaocredito.service.chain.services

import com.example.example.simulacaocredito.model.dto.ProcessoDTO
import com.example.example.simulacaocredito.model.dto.ResultadoSimulacaoResponseDTO
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class ResultadoService {

    var limitePermitido = BigDecimal(1000)
    var tipoResultado = ""
    var mensagem = ""

    fun obter(processoDTO: ProcessoDTO): ResultadoSimulacaoResponseDTO {

        this.mensagem = "Taxas encoontradas para o valor? ${processoDTO.valorFinanciado}"
        if (processoDTO.taxaJuros!! < BigDecimal(5)) {
            this.mensagem = "Menores taxas encoontradas para o valor? ${processoDTO.valorFinanciado}"
        }

        val limitePermitido = processoDTO.valorFinanciado!! > limitePermitido
        this.tipoResultado = if (limitePermitido) "APROVADO" else "REPROVADO"

        return ResultadoSimulacaoResponseDTO(
            idProposta = processoDTO.idProposta,
            tipoResultado = this.tipoResultado,
            mensagem = this.mensagem
        )
    }
}