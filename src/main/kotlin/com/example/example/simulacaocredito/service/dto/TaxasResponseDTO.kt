package com.example.example.simulacaocredito.service.dto

import com.example.example.simulacaocredito.service.enums.PeriodicidadeEnum
import java.math.BigDecimal

class TaxasResponseDTO(
    var juros: BigDecimal,
    var periodo: PeriodicidadeEnum
)