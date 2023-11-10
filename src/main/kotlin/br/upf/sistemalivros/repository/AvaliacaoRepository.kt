package br.upf.sistemalivros.repository

import br.upf.sistemalivros.model.Avaliacao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AvaliacaoRepository : JpaRepository<Avaliacao, Long> {

    fun findByUsuarioIdAndLivroId(idUsuario: Long, idLivro: Long): List<Avaliacao>
}