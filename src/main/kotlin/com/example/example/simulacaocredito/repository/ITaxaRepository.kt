package com.example.example.simulacaocredito.repository

import com.example.example.simulacaocredito.entity.TaxaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ITaxaRepository : JpaRepository<TaxaEntity, Long> {
}