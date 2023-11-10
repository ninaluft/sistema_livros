package br.upf.sistemalivros.repository

import br.upf.sistemalivros.model.Usuario
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface UsuarioRepository: JpaRepository<Usuario, Long> {
    fun findByNome(nomeUsuario: String, paginacao: Pageable): Page<Usuario>
}
