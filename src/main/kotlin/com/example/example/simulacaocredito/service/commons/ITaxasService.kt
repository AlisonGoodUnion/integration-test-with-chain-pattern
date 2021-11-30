package com.example.example.simulacaocredito.service.commons

import com.example.example.simulacaocredito.service.dto.TaxasResponseDTO

interface ITaxasService {
    fun obterTaxas(): TaxasResponseDTO
}