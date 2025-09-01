CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    username VARCHAR(255),
    password VARCHAR(255),
    email VARCHAR(255),
    cpf VARCHAR(11),
    crm VARCHAR(6),
    telefone VARCHAR(20),
    -- Campos do endereço embutido (vêm de Endereco)
    logradouro VARCHAR(255),
    numero VARCHAR(50),
    complemento VARCHAR(255),
    bairro VARCHAR(100),
    cidade VARCHAR(100),
    uf CHAR(2),
    cep VARCHAR(20),
    ativo BOOLEAN DEFAULT TRUE
);
