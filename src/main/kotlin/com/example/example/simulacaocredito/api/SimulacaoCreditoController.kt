package com.example.example.simulacaocredito.api

import com.example.example.simulacaocredito.model.dto.ResultadoSimulacaoResponseDTO
import com.example.example.simulacaocredito.model.dto.SimulacaoCreditoRequestDTO
import com.example.example.simulacaocredito.model.dto.TaxaDTO
import com.example.example.simulacaocredito.service.chain.services.ICreditoService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
class SimulacaoCreditoController(
    private val creditoService: ICreditoService
) {

    @GetMapping("v1/simulacao-credito", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun realizarSimulacao(simulacaoCreditoRequestDTO: SimulacaoCreditoRequestDTO): ResponseEntity<ResultadoSimulacaoResponseDTO> {
        return ResponseEntity(creditoService.realizarSimulacao(simulacaoCreditoRequestDTO), HttpStatus.OK)
    }

    @PostMapping("v1/taxas", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun criarTaxa(@RequestBody taxaDTO: TaxaDTO): ResponseEntity<TaxaDTO> {
        return ResponseEntity(creditoService.criarTaxa(taxaDTO), HttpStatus.OK)
    }

    @GetMapping("v1/taxas", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun criarTaxa(): ResponseEntity<List<TaxaDTO>> {
        val taxas = creditoService.buscarTaxas(null)
        return ResponseEntity(taxas, HttpStatus.OK)
    }

    @GetMapping("v1/taxas/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun criarTaxa(@PathVariable id: Long): ResponseEntity<List<TaxaDTO>> {
        val taxas = creditoService.buscarTaxas(id)
        return ResponseEntity(taxas, HttpStatus.OK)
    }

    //TODO CRUD REST TAXA
    //TODO CRUD REST VALOR SUGERIDO
    //TODO implementar flyway h2 com schema de tabela de taxa e valores sujeridos.
    //TODO implementar repository jpa class e consultas
}