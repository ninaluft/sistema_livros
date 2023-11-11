CREATE TABLE Avaliacao (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    usuario_id BIGINT,
    livro_id BIGINT,
    comentario VARCHAR(255) NOT NULL,
    nota DECIMAL(3, 2) NOT NULL,
    data TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id),
    FOREIGN KEY (livro_id) REFERENCES Livro(id)
);