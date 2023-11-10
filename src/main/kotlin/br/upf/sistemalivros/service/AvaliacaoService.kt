package br.upf.sistemalivros.service

import br.upf.sistemalivros.converters.AvaliacaoConverter
import br.upf.sistemalivros.dtos.AvaliacaoDTO
import br.upf.sistemalivros.dtos.AvaliacaoResponseDTO
import br.upf.sistemalivros.exceptions.NotFoundException
import br.upf.sistemalivros.repository.AvaliacaoRepository
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.stereotype.Service
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

@Service
class AvaliacaoService(private val repository: AvaliacaoRepository,
                       private val livroService: LivroService,
                       private val converter: AvaliacaoConverter,
                       private val entityManager: EntityManager  ) {

    fun listar(paginacao: Pageable): Page<AvaliacaoResponseDTO> {
        val avaliacoes = repository.findAll(paginacao)
        return avaliacoes.map(converter::toAvaliacaoResponseDTO)
    }


    fun buscarPorId(id: Long): AvaliacaoResponseDTO {
        val avaliacao = repository.findById(id)
            .orElseThrow { NotFoundException("Avaliação não encontrada!") }
        return converter.toAvaliacaoResponseDTO(avaliacao)
    }

    fun cadastrar(dto: AvaliacaoDTO): AvaliacaoResponseDTO {
        val avaliacao = converter.toAvaliacao(dto)
        val savedAvaliacao = repository.save(avaliacao)
        livroService.atualizarMediaAvaliacoes(avaliacao.livro.id!!)
        return converter.toAvaliacaoResponseDTO(savedAvaliacao)
    }

    fun atualizar(id: Long, dto: AvaliacaoDTO): AvaliacaoResponseDTO {
        val avaliacao = repository.findById(id)
            .orElseThrow { NotFoundException("Avaliação não encontrada!") }
            .copy(
                usuario = dto.usuario,
                livro = dto.livro,
                comentario = dto.comentario,
                nota = dto.nota
            )
        val updatedAvaliacao = repository.save(avaliacao)
        livroService.atualizarMediaAvaliacoes(avaliacao.livro.id!!)
        return converter.toAvaliacaoResponseDTO(updatedAvaliacao)
    }


        fun deletar(id: Long) {
            repository.findById(id).ifPresent { avaliacao ->
                val livro = avaliacao.livro
                repository.deleteById(id)

                // Forçar a sincronização com o banco de dados
                entityManager.flush()
                livroService.atualizarMediaAvaliacoes(livro.id!!)
            }
        }
    }
