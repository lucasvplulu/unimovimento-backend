ALTER TABLE evento
    ADD COLUMN autor_criacao varchar(255) NOT NULL,
    ADD COLUMN autor_modificacao varchar(255) NOT NULL,
    ADD COLUMN data_criacao timestamp NOT NULL,
    ADD COLUMN data_modificacao timestamp NOT NULL;

ALTER TABLE informacao_pagamento
    ADD COLUMN autor_criacao varchar(255) NOT NULL,
    ADD COLUMN autor_modificacao varchar(255) NOT NULL,
    ADD COLUMN data_criacao timestamp NOT NULL,
    ADD COLUMN data_modificacao timestamp NOT NULL;

ALTER TABLE pagamento
    ADD COLUMN autor_criacao varchar(255) NOT NULL,
    ADD COLUMN autor_modificacao varchar(255) NOT NULL,
    ADD COLUMN data_criacao timestamp NOT NULL,
    ADD COLUMN data_modificacao timestamp NOT NULL;

ALTER TABLE pessoa
    ADD COLUMN autor_criacao varchar(255) NOT NULL,
    ADD COLUMN autor_modificacao varchar(255) NOT NULL,
    ADD COLUMN data_criacao timestamp NOT NULL,
    ADD COLUMN data_modificacao timestamp NOT NULL;

ALTER TABLE pessoa_conhecimentos
    ADD COLUMN autor_criacao varchar(255) NOT NULL,
    ADD COLUMN autor_modificacao varchar(255) NOT NULL,
    ADD COLUMN data_criacao timestamp NOT NULL,
    ADD COLUMN data_modificacao timestamp NOT NULL;

ALTER TABLE pessoa_contatos
    ADD COLUMN autor_criacao varchar(255) NOT NULL,
    ADD COLUMN autor_modificacao varchar(255) NOT NULL,
    ADD COLUMN data_criacao timestamp NOT NULL,
    ADD COLUMN data_modificacao timestamp NOT NULL;

ALTER TABLE pessoa_curiosidades
    ADD COLUMN autor_criacao varchar(255) NOT NULL,
    ADD COLUMN autor_modificacao varchar(255) NOT NULL,
    ADD COLUMN data_criacao timestamp NOT NULL,
    ADD COLUMN data_modificacao timestamp NOT NULL;

ALTER TABLE pessoa_documentos
    ADD COLUMN autor_criacao varchar(255) NOT NULL,
    ADD COLUMN autor_modificacao varchar(255) NOT NULL,
    ADD COLUMN data_criacao timestamp NOT NULL,
    ADD COLUMN data_modificacao timestamp NOT NULL;

ALTER TABLE pessoa_dados_emergencia
    ADD COLUMN autor_criacao varchar(255) NOT NULL,
    ADD COLUMN autor_modificacao varchar(255) NOT NULL,
    ADD COLUMN data_criacao timestamp NOT NULL,
    ADD COLUMN data_modificacao timestamp NOT NULL;

ALTER TABLE pessoa_contatos_emergencia
    ADD COLUMN autor_criacao varchar(255) NOT NULL,
    ADD COLUMN autor_modificacao varchar(255) NOT NULL,
    ADD COLUMN data_criacao timestamp NOT NULL,
    ADD COLUMN data_modificacao timestamp NOT NULL;

ALTER TABLE pessoa_endereco
    ADD COLUMN autor_criacao varchar(255) NOT NULL,
    ADD COLUMN autor_modificacao varchar(255) NOT NULL,
    ADD COLUMN data_criacao timestamp NOT NULL,
    ADD COLUMN data_modificacao timestamp NOT NULL;

ALTER TABLE pessoa_interesses
    ADD COLUMN autor_criacao varchar(255) NOT NULL,
    ADD COLUMN autor_modificacao varchar(255) NOT NULL,
    ADD COLUMN data_criacao timestamp NOT NULL,
    ADD COLUMN data_modificacao timestamp NOT NULL;

ALTER TABLE pessoa_dados_ministeriais
    ADD COLUMN autor_criacao varchar(255) NOT NULL,
    ADD COLUMN autor_modificacao varchar(255) NOT NULL,
    ADD COLUMN data_criacao timestamp NOT NULL,
    ADD COLUMN data_modificacao timestamp NOT NULL;