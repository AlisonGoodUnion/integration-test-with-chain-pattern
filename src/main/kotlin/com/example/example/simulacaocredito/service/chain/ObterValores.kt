package com.example.example.simulacaocredito.service.chain

import com.example.example.simulacaocredito.model.dto.ResultadoSimulacaoResponseDTO
import com.example.example.simulacaocredito.service.IValoresService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Service

//TODO criar enum para os orders
@Order(1)
@Service
class ObterValores @Autowired constructor(
    private val valoresService: IValoresService
): IProcessoSimulacao {

    override fun execute(resultado: ResultadoSimulacaoResponseDTO) {
        val obterValores = valoresService.obterValores()

        //TODO validar se retorno contem valores e criar exception tratada.

        resultado.informarValores(
            valorSugerido = obterValores.valorSugerido!!,
            valorFinanciado = obterValores.valorFinanciado!!
        )
    }

}