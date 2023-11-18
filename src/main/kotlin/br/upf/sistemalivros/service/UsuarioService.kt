package br.upf.sistemalivros.service

import br.upf.sistemalivros.converters.UsuarioConverter
import br.upf.sistemalivros.dtos.UsuarioDTO
import br.upf.sistemalivros.dtos.UsuarioResponseDTO
import br.upf.sistemalivros.exceptions.NotFoundException
import br.upf.sistemalivros.repository.UsuarioRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

private const val USUARIO_NOT_FOUND_MESSAGE = "Usuário não encontrado!"

@Service
class UsuarioService(private val repository: UsuarioRepository,
                     private val converter: UsuarioConverter
) {
    fun listar(
        nomeUsuario: String?,
        paginacao: Pageable
    ): Page<UsuarioResponseDTO> {
        val usuarios = if (nomeUsuario == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByNome(nomeUsuario, paginacao)
        }
        return usuarios
            .map(converter::toUsuarioResponseDTO)
    }

    fun buscarPorId(id: Long): UsuarioResponseDTO {
        val usuario = repository.findById(id)
            .orElseThrow { NotFoundException(USUARIO_NOT_FOUND_MESSAGE) }
        return converter.toUsuarioResponseDTO(usuario)
    }

    fun cadastrar(dto: UsuarioDTO): UsuarioResponseDTO {
        return converter.toUsuarioResponseDTO(repository.save(converter.toUsuario(dto)))
    }

    fun atualizar(id: Long, dto: UsuarioDTO): UsuarioResponseDTO {
        val usuario = repository.findById(id)
            .orElseThrow{ NotFoundException(USUARIO_NOT_FOUND_MESSAGE)}
            .copy(
                nome = dto.nome,
                email = dto.email
            )
        return converter.toUsuarioResponseDTO(repository.save(usuario))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }

}