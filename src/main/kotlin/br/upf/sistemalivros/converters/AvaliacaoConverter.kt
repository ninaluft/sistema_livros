package br.upf.sistemalivros.converters

import br.upf.sistemalivros.dtos.AvaliacaoDTO
import br.upf.sistemalivros.dtos.AvaliacaoResponseDTO
import br.upf.sistemalivros.model.Avaliacao
import org.springframework.stereotype.Component

@Component
class AvaliacaoConverter {
    fun toAvaliacao(dto: AvaliacaoDTO): Avaliacao {
        return Avaliacao(
            usuario = dto.usuario,
            livro = dto.livro,
            comentario = dto.comentario,
            nota = dto.nota
        )
    }

    fun toAvaliacaoResponseDTO(avaliacao: Avaliacao): AvaliacaoResponseDTO {
        return AvaliacaoResponseDTO(
            id = avaliacao.id,
            usuario = avaliacao.usuario,
            livro = avaliacao.livro,
            comentario = avaliacao.comentario,
            nota = avaliacao.nota,
            data = avaliacao.data
        )
    }
}
