package br.upf.sistemalivros.dtos

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class LivroDTO(    @field:NotEmpty(message = "O livro deve ter um título" )
                        val titulo: String,
                        @field:NotNull(message = "O livro deve ter um autor" )
                        val autor: String,
                        @field:NotNull(message = "O livro deve ter um ano de publicação" )
                        val anoPublicacao: Int,
                        @field:NotNull(message = "O livro deve ter código isbn" )
                        val isbn: String

)