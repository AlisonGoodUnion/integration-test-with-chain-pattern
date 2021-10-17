package com.example.example.simulacaocredito.api

import com.example.example.simulacaocredito.model.dto.ResultadoSimulacaoResponseDTO
import com.example.example.simulacaocredito.service.ICreditoService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class SimulacaoCreditoController(
    private val creditoService: ICreditoService
) {

    //TODO implementar flyway com schema de tabela de taxa e valores sujeridos.
    //TODO implementar repository jpa class e consultas

    @GetMapping("v1/simulacao-credito/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun realizarSimulacao(@PathVariable(name = "id") idProposta: Long): ResponseEntity<ResultadoSimulacaoResponseDTO> {
        return ResponseEntity(creditoService.realizarSimulacao(idProposta), HttpStatus.OK)
    }

    //TODO CRUD REST TAXA
    //TODO CRUD REST VALOR SUGERIDO
}