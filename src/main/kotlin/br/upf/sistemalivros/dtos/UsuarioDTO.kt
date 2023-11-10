package br.upf.sistemalivros.dtos

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class UsuarioDTO(
    @field:NotEmpty(message = "Usuário deve ter um nome" )
    val nome: String,
    @field:NotNull(message = "Usuário deve ter um email" )
    val email: String

)