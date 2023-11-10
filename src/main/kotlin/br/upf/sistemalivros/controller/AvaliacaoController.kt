package br.upf.sistemalivros.controller

import br.upf.sistemalivros.dtos.AvaliacaoDTO
import br.upf.sistemalivros.dtos.AvaliacaoResponseDTO
import br.upf.sistemalivros.service.AvaliacaoService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

@RestController
@RequestMapping("/avaliacoes")
class AvaliacaoController(val service: AvaliacaoService) {

    @GetMapping
    fun listar(paginacao: Pageable): Page<AvaliacaoResponseDTO> {
        return service.listar(paginacao)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): AvaliacaoResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody @Valid dto: AvaliacaoDTO,
                  uriBuilder: UriComponentsBuilder
    ): ResponseEntity<AvaliacaoResponseDTO> {
        val avaliacaoResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/avaliacoes/${avaliacaoResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(avaliacaoResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long,
                  @RequestBody @Valid dto: AvaliacaoDTO
    ): AvaliacaoResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}