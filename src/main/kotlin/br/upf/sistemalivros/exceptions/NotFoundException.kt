package br.upf.sistemalivros.exceptions

import java.lang.RuntimeException

class NotFoundException(override val message: String)
    : RuntimeException()