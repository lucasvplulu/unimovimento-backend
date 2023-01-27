CREATE TABLE pessoa_conhecimentos (
    id CHAR(36) NOT NULL,
    conhecimento varchar(255) DEFAULT NULL,
    pessoa_id CHAR(36),
    PRIMARY KEY (id),
    CONSTRAINT fk_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoa (id)
);

CREATE TABLE pessoa_contatos (
    id CHAR(36) NOT NULL,
    email varchar(255) DEFAULT NULL,
    celular varchar(255) DEFAULT NULL,
    pessoa_id CHAR(36),
    PRIMARY KEY (id),
    CONSTRAINT fk_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoa (id) ON DELETE CASCADE
);

CREATE TABLE pessoa_curiosidades (
    id CHAR(36) NOT NULL,
    livro_favorito_biblia varchar(255) DEFAULT NULL,
    livro_favorito varchar(255) DEFAULT NULL,
    cantor_banda_favorito varchar(255) DEFAULT NULL,
    prato_favorito varchar(255) DEFAULT NULL,
    hobbies varchar(255) DEFAULT NULL,
    pessoa_id CHAR(36),
    PRIMARY KEY (id),
    CONSTRAINT fk_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoa (id)
);

CREATE TABLE pessoa_documentos (
    id CHAR(36) NOT NULL,
    cpf varchar(11) NOT NULL UNIQUE,
    rg varchar(255) DEFAULT NULL,
    rg_emissor varchar(255) DEFAULT NULL,
    pessoa_id CHAR(36),
    PRIMARY KEY (id),
    CONSTRAINT fk_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoa (id) ON DELETE CASCADE
);

CREATE TABLE pessoa_dados_emergencia (
    id CHAR(36) NOT NULL,
    toma_remedio BOOLEAN NOT NULL,
    descricao_remedio varchar(255) DEFAULT NULL,
    tem_alergia BOOLEAN NOT NULL,
    descricao_alergia varchar(255) DEFAULT NULL,
    tem_plano_saude BOOLEAN DEFAULT FALSE,
    descricao_plano_saude varchar(255) DEFAULT NULL,
    tipo_sanguineo varchar(255) NOT NULL,
    observacoes varchar(255) DEFAULT NULL,
    pessoa_id CHAR(36),
    PRIMARY KEY (id),
    CONSTRAINT fk_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoa (id)
);

CREATE TABLE pessoa_contatos_emergencia (
    id CHAR(36) NOT NULL,
    nome varchar(255) DEFAULT NULL,
    celular varchar(255) DEFAULT NULL,
    emergencia_id CHAR(36),
    PRIMARY KEY (id),
    CONSTRAINT fk_pessoa_dados_emergencia FOREIGN KEY (emergencia_id) REFERENCES pessoa_dados_emergencia (id) ON DELETE CASCADE
);

CREATE TABLE pessoa_interesses (
    id CHAR(36) NOT NULL,
    interesse varchar(255) DEFAULT NULL,
    descricao_outro_interesse varchar(255) DEFAULT NULL,
    pessoa_id CHAR(36),
    PRIMARY KEY (id),
    CONSTRAINT fk_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoa (id)
);

CREATE TABLE pessoa_dados_ministeriais (
    id CHAR(36) NOT NULL,
    vocacao varchar(255) NOT NULL,
    descricao_vocacao varchar(255) DEFAULT NULL,
    congregacao varchar(255) NOT NULL,
    batizado BOOLEAN NOT NULL,
    data_batismo date DEFAULT NULL,
    funcao_ministerio_jovens varchar(255) NOT NULL,
    funcao_eclesiastica varchar(255) NOT NULL,
    origem_outra_denominacao BOOLEAN NOT NULL,
    nome_outra_denominacao varchar(255) DEFAULT NULL,
    leu_toda_biblia BOOLEAN NOT NULL,
    formacao_teologica BOOLEAN NOT NULL,
    descricao_formacao_teologica varchar(255) DEFAULT NULL,
    biografia varchar(255) DEFAULT NULL,
    pessoa_id CHAR(36),
    PRIMARY KEY (id),
    CONSTRAINT fk_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoa (id)
);

ALTER TABLE pessoa
    ADD COLUMN documento_id CHAR(36) NOT NULL UNIQUE,
    ADD COLUMN contato_id CHAR(36) NOT NULL,
    ADD COLUMN tamanho_camisa varchar(255) DEFAULT NULL,
    ADD COLUMN tipo_camisa varchar(255) DEFAULT NULL,
    ADD COLUMN tipo_voz_coral varchar(255) DEFAULT NULL,
    ADD CONSTRAINT fk_pessoa_documentos FOREIGN KEY (documento_id) REFERENCES pessoa_documentos (id) ON DELETE CASCADE,
    ADD CONSTRAINT fk_pessoa_contatos FOREIGN KEY (contato_id) REFERENCES pessoa_contatos (id) ON DELETE CASCADE;