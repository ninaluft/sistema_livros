package br.upf.sistemalivros.dtos


import br.upf.sistemalivros.model.Livro
import br.upf.sistemalivros.model.Usuario
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class AvaliacaoDTO(
    @field:NotNull(message = "O usuário não pode ser nulo")
    val usuario: Usuario,
    @field:NotNull(message = "O livro não pode ser nulo")
    val livro: Livro,
    @field:NotEmpty(message = "A avaliação deve conter um comentário")
    val comentario: String,
    @field:NotNull(message = "A avaliação deve conter uma nota")
    val nota: Double
)
