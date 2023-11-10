package br.upf.sistemalivros.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
data class Usuario(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val email: String,
    @OneToMany(mappedBy = "usuario")
    val avaliacoes: List<Avaliacao> = listOf()
)
