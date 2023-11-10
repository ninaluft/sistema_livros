package br.upf.sistemalivros.converters

import br.upf.sistemalivros.dtos.UsuarioDTO
import br.upf.sistemalivros.dtos.UsuarioResponseDTO
import br.upf.sistemalivros.model.Usuario
import org.springframework.stereotype.Component

@Component
class UsuarioConverter {
    fun toUsuario(dto: UsuarioDTO): Usuario {
        return Usuario(
            nome = dto.nome,
            email = dto.email
        )
    }

    fun toUsuarioResponseDTO(usuario: Usuario):
            UsuarioResponseDTO {
        return UsuarioResponseDTO(
            id = usuario.id,
            nome = usuario.nome,
            email = usuario.email

        )
    }
}
