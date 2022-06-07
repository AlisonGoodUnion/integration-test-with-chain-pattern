package com.example.example.simulacaocredito.api

import com.example.example.IntegrationTestWithChainPatternApplication
import com.example.example.simulacaocredito.model.dto.TaxaDTO
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import org.hamcrest.CoreMatchers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration.FlywayConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.io.IOException
import java.math.BigDecimal

@SpringBootTest(
        classes = [IntegrationTestWithChainPatternApplication::class, FlywayConfiguration::class],
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ExtendWith(SpringExtension::class)
@AutoConfigureMockMvc
internal class SimulacaoCreditoControllerTestIT {

    @Autowired
    lateinit var mvc: MockMvc


    @Test
    fun `Deve retornar taxas`() {

        mvc.perform(get("/v1/taxas")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful)
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", CoreMatchers.`is`(1)))
    }

    @Test
    fun `Deve retornar taxas de codigo 1`() {

        mvc.perform(get("/v1/taxas/1")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful)
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", CoreMatchers.`is`(1)))
    }

    @Test
    fun `Deve criar taxa`() {
        val taxaDTO = TaxaDTO(2, "CDI", BigDecimal.TEN)
        mvc.perform(post("/v1/taxa")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(taxaDTO))
        )
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful)
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.`is`(2)))
    }

    @Throws(IOException::class)
    fun toJson(dados: Any): String {
        val mapper = ObjectMapper()
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
        return mapper.writeValueAsString(dados)
    }
}