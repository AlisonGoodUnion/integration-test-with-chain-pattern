package com.example.example.simulacaocredito.entity

import org.hibernate.annotations.GenericGenerator
import java.io.Serializable
import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "TAXAS", schema = "mydb")
data class TaxaEntity(

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "mydb.TAXAS_SEQ", strategy = GenerationType.SEQUENCE)
    @GenericGenerator(
            name = "mydb.TAXAS_SEQ", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = [
                org.hibernate.annotations.Parameter(name = "sequence_name", value = "mydb.TAXAS_SEQ"),
                org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                org.hibernate.annotations.Parameter(name = "increment_size", value = "1")]
    )
    var id: Long? = null,

    @Column(name = "nome")
    var nome: String,

    @Column(name = "valor")
    var valor: BigDecimal,

) : Serializable {

}

