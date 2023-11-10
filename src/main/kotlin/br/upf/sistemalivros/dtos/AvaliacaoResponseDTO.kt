package br.upf.sistemalivros.dtos

import br.upf.sistemalivros.model.Usuario
import br.upf.sistemalivros.model.Livro
import java.time.LocalDateTime

data class AvaliacaoResponseDTO(
    val id: Long? = null,
    val usuario: Usuario,
    val livro: Livro,
    val comentario: String,
    val nota: Double,
    val data: LocalDateTime = LocalDateTime.now()
)