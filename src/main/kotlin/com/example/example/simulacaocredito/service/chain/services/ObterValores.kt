package com.example.example.simulacaocredito.service.chain.services

import com.example.example.simulacaocredito.model.dto.ProcessoDTO
import com.example.example.simulacaocredito.service.chain.IProcessoSimulacaoService
import com.example.example.simulacaocredito.service.commons.IValoresService
import com.example.example.simulacaocredito.service.chain.constants.OrdemSimulacaoConstants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Service


@Order(OrdemSimulacaoConstants.ETAPA_1)
@Service
class ObterValores @Autowired constructor(
    private val valoresService: IValoresService
) : IProcessoSimulacaoService {

    override fun execute(processo: ProcessoDTO) {
        val obterValores = valoresService.obterValores(idProposta = processo.idProposta)
        processo.informarValores(valorFinanciado = obterValores.valorFinanciado)
    }

}