package com.example.example.simulacaocredito.model.dto

import com.example.example.simulacaocredito.entity.TaxaEntity
import java.math.BigDecimal

class TaxaDTO(val id: Long,
                   val nome: String,
                   val valor: BigDecimal) {

    fun toEntity(taxaEntity: TaxaEntity): TaxaEntity {
        return TaxaEntity(
                this.id,
                this.nome,
                this.valor,
        )
    }


    fun toDTO(taxaEntity: TaxaEntity): TaxaDTO {
        return TaxaDTO(
                this.id,
                this.nome,
                this.valor,
        )
    }


}