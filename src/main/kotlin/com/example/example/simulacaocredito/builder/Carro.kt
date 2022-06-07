package com.example.example.simulacaocredito.builder

class Carro(
        val modelo: String?,
        val cor: String?,
        val tipo: String?
) {
    data class Builder(
            var modelo: String? = null,
            var cor: String? = null,
            var tipo: String? = null,
    ) {

        fun modelo(modelo: String) {
            this.modelo = modelo
        }
        fun cor(cor: String?) = apply { this.cor = cor }
        fun tipo(tipo: String?) = apply { this.tipo = tipo }

        fun build() = Carro(modelo, cor, tipo)

    }
}