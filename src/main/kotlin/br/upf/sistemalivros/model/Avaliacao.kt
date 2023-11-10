package br.upf.sistemalivros.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Avaliacao(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne
    @JsonIgnore
    val usuario: Usuario,
    @ManyToOne
    @JsonIgnore
    val livro: Livro,
    val comentario: String,
    val nota: Double,
    val data: LocalDateTime = LocalDateTime.now()
)
