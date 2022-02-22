package com.example.example.simulacaocredito.service.commons

import com.example.example.simulacaocredito.service.dto.ValoresResponseDTO
import org.springframework.stereotype.Service
import java.math.BigDecimal

//TODO Injecao JPA repository
@Service
class ValoresService : IValoresService {

    //TODO simulacao consumo de service ou banco
    override fun obterValores(idProposta: Long): ValoresResponseDTO {

        //BANCO *
        //SERVICO
        return ValoresResponseDTO(valorFinanciado = BigDecimal(20000L))
    }
}