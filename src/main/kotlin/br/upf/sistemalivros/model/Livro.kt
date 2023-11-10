package br.upf.sistemalivros.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
data class Livro(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val titulo: String,
    val autor: String,
    val anoPublicacao: Int,
    val isbn: String,
    var mediaAvaliacoes: Double = 0.0,
    @OneToMany(mappedBy = "livro", cascade = arrayOf(CascadeType.REMOVE), orphanRemoval = true)
    @JsonIgnore
    val avaliacoes: List<Avaliacao> = listOf()

)