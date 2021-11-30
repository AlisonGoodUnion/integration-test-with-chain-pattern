package com.example.example.simulacaocredito.service.commons

import com.example.example.simulacaocredito.service.dto.ValoresResponseDTO

interface IValoresService {
    fun obterValores(idProposta: Long): ValoresResponseDTO
}