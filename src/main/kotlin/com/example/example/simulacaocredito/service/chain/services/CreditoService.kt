package com.example.example.simulacaocredito.service.chain.services

import com.example.example.simulacaocredito.entity.TaxaEntity
import com.example.example.simulacaocredito.model.dto.ProcessoDTO
import com.example.example.simulacaocredito.model.dto.ResultadoSimulacaoResponseDTO
import com.example.example.simulacaocredito.model.dto.SimulacaoCreditoRequestDTO
import com.example.example.simulacaocredito.model.dto.TaxaDTO
import com.example.example.simulacaocredito.repository.ITaxaRepository
import com.example.example.simulacaocredito.service.chain.IProcessoSimulacaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class CreditoService @Autowired constructor(
        private val processoSimulacao: List<IProcessoSimulacaoService>,
        private val resultadoService: ResultadoService,
        private val taxaRepository: ITaxaRepository,
) : ICreditoService {

    override fun realizarSimulacao(simulacaoCreditoRequestDTO: SimulacaoCreditoRequestDTO): ResultadoSimulacaoResponseDTO {
        val processoDTO = ProcessoDTO(simulacaoCreditoRequestDTO.id)

        processoSimulacao.forEach { it.execute(processoDTO) }
        return resultadoService.obter(processoDTO)
    }

    override fun criarTaxa(taxaDTO: TaxaDTO): TaxaDTO {
        val taxaEntity = TaxaEntity(
                id = taxaDTO.id,
                nome = taxaDTO.nome,
                valor = taxaDTO.valor,
        )
        val entity = taxaRepository.save(taxaEntity)
        return TaxaDTO(
                id = entity.id!!,
                nome = entity.nome,
                valor = entity.valor
        )
    }

    override fun buscarTaxas(id: Long?): List<TaxaDTO> {
        if (id != null) {
            val taxaEntity = taxaRepository.findById(id).get()
            val taxaDTO = TaxaDTO(
                    id = taxaEntity.id!!,
                    nome = taxaEntity.nome,
                    valor = taxaEntity.valor,
            )

            return listOf(taxaDTO)
        }

        val taxas = taxaRepository.findAll()
        return taxas.stream()
                .map { TaxaDTO(it.id!!, it.nome, it.valor) }
                .collect(Collectors.toList())
    }
}