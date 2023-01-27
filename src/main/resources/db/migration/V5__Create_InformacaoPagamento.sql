create table informacao_pagamento (
    id CHAR(36) not null,
    pessoa_id CHAR(36),
    evento_id CHAR(36),
    situacao varchar(255) DEFAULT NULL,
    tipo_pagamento varchar(255) DEFAULT NULL,
    qtd_parcela int DEFAULT NULL,
    primary key (id)
);

ALTER TABLE informacao_pagamento
    ADD CONSTRAINT fk_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoa (id);

ALTER TABLE informacao_pagamento
    ADD CONSTRAINT fk_evento FOREIGN KEY (evento_id) REFERENCES evento (id);