create table pagamento (
    id CHAR(36) not null,
    valor NUMERIC (10, 2),
    valor_liquido NUMERIC (10, 2),
    dt_pagamento date DEFAULT NULL,
    dt_vencimento date DEFAULT NULL,
    situacao int DEFAULT NULL,
    hash varchar(255),
    boleto_url varchar(255),
    numero_parcela int DEFAULT NULL,
    numero_cartao varchar(255),
    informacao_pagamento_id CHAR(36),
    primary key (id)
);

ALTER TABLE pagamento
    ADD CONSTRAINT fk_informacao_pagamento FOREIGN KEY (informacao_pagamento_id) REFERENCES informacao_pagamento (id);