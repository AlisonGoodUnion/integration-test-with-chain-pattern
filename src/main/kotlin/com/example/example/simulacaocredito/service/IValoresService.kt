package com.example.example.simulacaocredito.service

import com.example.example.simulacaocredito.model.dto.ValoresResponseDTO

interface IValoresService {
    fun obterValores(): ValoresResponseDTO
}