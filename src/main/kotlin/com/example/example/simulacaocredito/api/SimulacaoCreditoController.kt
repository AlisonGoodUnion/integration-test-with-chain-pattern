package com.example.example.simulacaocredito.api

import com.example.example.simulacaocredito.model.dto.ResultadoSimulacaoResponseDTO
import com.example.example.simulacaocredito.model.dto.SimulacaoCreditoRequestDTO
import com.example.example.simulacaocredito.service.chain.services.ICreditoService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class SimulacaoCreditoController(
    private val creditoService: ICreditoService
) {

    @GetMapping("v1/simulacao-credito", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun realizarSimulacao(simulacaoCreditoRequestDTO: SimulacaoCreditoRequestDTO): ResponseEntity<ResultadoSimulacaoResponseDTO> {
        return ResponseEntity(creditoService.realizarSimulacao(simulacaoCreditoRequestDTO), HttpStatus.OK)
    }

    //TODO CRUD REST TAXA
    //TODO CRUD REST VALOR SUGERIDO
    //TODO implementar flyway h2 com schema de tabela de taxa e valores sujeridos.
    //TODO implementar repository jpa class e consultas
}