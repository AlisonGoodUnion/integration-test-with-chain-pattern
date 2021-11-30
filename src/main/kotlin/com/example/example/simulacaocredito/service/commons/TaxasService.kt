package com.example.example.simulacaocredito.service.commons

import com.example.example.simulacaocredito.service.enums.PeriodicidadeEnum
import com.example.example.simulacaocredito.service.dto.TaxasResponseDTO
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class TaxasService : ITaxasService {
    override fun obterTaxas(): TaxasResponseDTO {
        return TaxasResponseDTO(BigDecimal(4.5), PeriodicidadeEnum.A)
    }
}