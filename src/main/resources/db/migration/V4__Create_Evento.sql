create table evento (
    id CHAR(36) not null,
    nome varchar(255) NOT NULL,
    descricao varchar(255) DEFAULT NULL,
    data_inicio date DEFAULT NULL,
    data_final date DEFAULT NULL,
    data_final_inscricao date DEFAULT NULL,
    data_final_boleto date DEFAULT NULL,
    primary key (id)
);
