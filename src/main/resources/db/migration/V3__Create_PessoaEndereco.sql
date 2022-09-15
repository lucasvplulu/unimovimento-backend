create table pessoa_endereco (
    id CHAR(36) not null,
    bairro varchar(255),
    cep varchar(8),
    cidade varchar(255),
    complemento varchar(255),
    estado varchar(255),
    logradouro varchar(255),
    numero varchar(255),
    pais varchar(255),
    pessoa_id CHAR(36),
    primary key (id)
);

ALTER TABLE pessoa_endereco
    ADD CONSTRAINT fk_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoa (id);