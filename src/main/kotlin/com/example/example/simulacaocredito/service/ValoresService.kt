package com.example.example.simulacaocredito.service

import com.example.example.simulacaocredito.model.dto.ValoresResponseDTO
import org.springframework.stereotype.Service
import java.math.BigDecimal

//TODO Injecao JPA repository
@Service
class ValoresService : IValoresService {

    //TODO simulacao consumo de service ou banco
    override fun obterValores(): ValoresResponseDTO {
        return ValoresResponseDTO(
            valorSugerido = BigDecimal(10000L),
            valorFinanciado = BigDecimal(20000L)
        )
    }
}