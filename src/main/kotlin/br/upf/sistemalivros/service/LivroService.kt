package br.upf.sistemalivros.service

import br.upf.sistemalivros.converters.LivroConverter
import br.upf.sistemalivros.dtos.LivroDTO
import br.upf.sistemalivros.dtos.LivroResponseDTO
import br.upf.sistemalivros.exceptions.NotFoundException
import br.upf.sistemalivros.repository.LivroRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class LivroService(private val repository: LivroRepository,
                   private val converter: LivroConverter
) {

    fun listar(
        tituloLivro: String?,
        paginacao: Pageable
    ): Page<LivroResponseDTO> {
        val livros = if (tituloLivro == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByTitulo(tituloLivro, paginacao)
        }
        return livros
            .map(converter::toLivroResponseDTO)
    }

    fun buscarPorId (id: Long): LivroResponseDTO {
        val livro = repository .findById(id)
            .orElseThrow { NotFoundException("Livro não encontrado!") }
        return converter.toLivroResponseDTO(livro)
    }

    fun cadastrar(dto: LivroDTO): LivroResponseDTO {
        return converter.toLivroResponseDTO(
            repository.save(converter.toLivro(dto)))
    }

    fun atualizar(id: Long, dto: LivroDTO): LivroResponseDTO {
        val livro = repository.findById(id)
            .orElseThrow { NotFoundException("Livro não encontrado!") }
            .copy(
                titulo = dto.titulo,
                autor = dto.autor,
                anoPublicacao = dto.anoPublicacao,
                isbn = dto.isbn

            )
        return converter.toLivroResponseDTO(repository.save(livro))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }

    fun atualizarMediaAvaliacoes(livroId: Long) {
        val livro = repository.findById(livroId)
            .orElseThrow { NotFoundException("Livro não encontrado!") }
        val avaliacoes = livro.avaliacoes
        val mediaAvaliacoes = if (avaliacoes.isNotEmpty()) {
            avaliacoes.map { it.nota }.average()
        } else {
            0.0
        }
        livro.mediaAvaliacoes = mediaAvaliacoes
        repository.save(livro)
    }
}
