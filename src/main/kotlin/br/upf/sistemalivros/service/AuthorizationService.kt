package br.upf.sistemalivros.service

import br.upf.sistemalivros.repository.UsuarioRepository
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthorizationService(
    val repository: UsuarioRepository
) : UserDetailsService {
    override fun loadUserByUsername(email: String) =
        repository.findByEmail(email)
}