package br.upf.sistemalivros.dtos

import br.upf.sistemalivros.model.Avaliacao

data class LivroResponseDTO(
    val id: Long? = null,
    val titulo: String,
    val autor: String,
    val anoPublicacao: Int,
    val isbn: String,
    var mediaAvaliacoes: Double,
    val avaliacoes: List<Avaliacao> = listOf(),

    )
