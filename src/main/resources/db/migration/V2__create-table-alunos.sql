CREATE TABLE alunos (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    uf VARCHAR(2) NOT NULL,
    complemento VARCHAR(100),
    numero VARCHAR(20),
    telefone VARCHAR(20) NOT NULL,
    cpf VARCHAR(14) NOT NULL
);
