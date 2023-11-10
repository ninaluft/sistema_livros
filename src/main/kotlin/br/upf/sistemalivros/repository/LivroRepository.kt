package br.upf.sistemalivros.repository

import br.upf.sistemalivros.exceptions.NotFoundException
import br.upf.sistemalivros.model.Livro
import br.upf.sistemalivros.model.Usuario
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LivroRepository: JpaRepository<Livro, Long> {
    fun findByTitulo(tituloLivro: String, paginacao: Pageable): Page<Livro>

}
