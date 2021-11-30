package com.example.example.simulacaocredito.service.chain.services

import com.example.example.simulacaocredito.model.dto.ProcessoDTO
import com.example.example.simulacaocredito.service.chain.IProcessoSimulacaoService
import com.example.example.simulacaocredito.service.chain.constants.OrdemSimulacaoConstants
import com.example.example.simulacaocredito.service.commons.ITaxasService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Service

@Order(OrdemSimulacaoConstants.ETAPA_2)
@Service
class ObterTaxas @Autowired constructor(
    private val taxasService: ITaxasService
) : IProcessoSimulacaoService {

    override fun execute(processo: ProcessoDTO) {
        val dadosTaxas = taxasService.obterTaxas()
        processo.informarDadosTaxa(taxaJuros = dadosTaxas.juros, periodoTaxaJuros = dadosTaxas.periodo)
    }

}