create table formulario (
    id CHAR(36) not null,
    descricao varchar(255) NOT NULL,
    dt_evento date DEFAULT NULL,
    dt_final_inscricao date DEFAULT NULL,
    dt_final_boleto date DEFAULT NULL,
    primary key (id)
);
