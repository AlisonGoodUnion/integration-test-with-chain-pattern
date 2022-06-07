package com.example.example.simulacaocredito.model.dto

data class ResultadoSimulacaoResponseDTO(
    var idProposta: Long,
    var tipoResultado: String,
    var mensagem: String
 )