package br.upf.sistemalivros.dtos

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class UsuarioDTO(
    val nome: String,
    val senha: String,
    val email: String
)