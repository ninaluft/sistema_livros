CREATE TABLE Livro (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    anoPublicacao INT NOT NULL,
    isbn VARCHAR(255) NOT NULL,
    mediaAvaliacoes DECIMAL(3, 2) DEFAULT 0.0
);