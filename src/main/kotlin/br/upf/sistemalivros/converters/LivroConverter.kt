package br.upf.sistemalivros.converters

import br.upf.sistemalivros.dtos.LivroDTO
import br.upf.sistemalivros.dtos.LivroResponseDTO
import br.upf.sistemalivros.model.Livro
import org.springframework.stereotype.Component

@Component
class LivroConverter {
    fun toLivro(dto: LivroDTO): Livro {
        return Livro(
            titulo = dto.titulo,
            autor = dto.autor,
            anoPublicacao = dto.anoPublicacao,
            isbn = dto.isbn,
            avaliacoes = listOf()
        )

    }

    fun toLivroResponseDTO(livro: Livro):
            LivroResponseDTO {
        return LivroResponseDTO(
            id = livro.id,
            titulo = livro.titulo,
            autor = livro.autor,
            anoPublicacao = livro.anoPublicacao,
            isbn = livro.isbn,
            mediaAvaliacoes = livro.mediaAvaliacoes,
            avaliacoes = livro.avaliacoes

        )
    }
}